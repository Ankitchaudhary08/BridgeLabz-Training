package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {
    @Override
    public int create(Billing billing) {
        try (Connection connection = HikariConnectionPool.getConnection()) {
            return create(connection, billing);
        } catch (SQLException e) {
            System.out.println("Bill create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int create(Connection connection, Billing billing) throws SQLException {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, billing.getAppointmentId());
            statement.setBigDecimal(2, billing.getAmount());
            statement.setString(3, billing.getPaymentStatus());
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    @Override
    public Billing findById(int billId) {
        return findOne("SELECT * FROM billing WHERE bill_id = ?", billId);
    }

    @Override
    public Billing findByAppointmentId(int appointmentId) {
        return findOne("SELECT * FROM billing WHERE appointment_id = ?", appointmentId);
    }

    @Override
    public List<Billing> findAll() {
        List<Billing> bills = new ArrayList<>();
        String sql = "SELECT * FROM billing ORDER BY bill_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bills.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Bill list failed: " + e.getMessage());
        }
        return bills;
    }

    @Override
    public boolean update(Billing billing) {
        String sql = "UPDATE billing SET amount = ?, payment_status = ? WHERE bill_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBigDecimal(1, billing.getAmount());
            statement.setString(2, billing.getPaymentStatus());
            statement.setInt(3, billing.getBillId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Bill update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int billId) {
        String sql = "DELETE FROM billing WHERE bill_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, billId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Bill delete failed: " + e.getMessage());
            return false;
        }
    }

    private Billing findOne(String sql, int id) {
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Bill lookup failed: " + e.getMessage());
            return null;
        }
    }

    private Billing map(ResultSet resultSet) throws SQLException {
        Billing billing = new Billing();
        billing.setBillId(resultSet.getInt("bill_id"));
        billing.setAppointmentId(resultSet.getInt("appointment_id"));
        billing.setAmount(resultSet.getBigDecimal("amount"));
        billing.setPaymentStatus(resultSet.getString("payment_status"));
        Timestamp billingDate = resultSet.getTimestamp("billing_date");
        billing.setBillingDate(billingDate == null ? null : billingDate.toLocalDateTime());
        return billing;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
