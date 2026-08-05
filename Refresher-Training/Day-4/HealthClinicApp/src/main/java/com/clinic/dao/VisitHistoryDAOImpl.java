package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {
    @Override
    public int create(VisitHistory visitHistory) {
        try (Connection connection = HikariConnectionPool.getConnection()) {
            return create(connection, visitHistory);
        } catch (SQLException e) {
            System.out.println("Visit history create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int create(Connection connection, VisitHistory visitHistory) throws SQLException {
        String sql = """
                INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes)
                VALUES (?, ?, ?, ?)
                """;
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, visitHistory.getAppointmentId());
            statement.setString(2, visitHistory.getDiagnosis());
            statement.setString(3, visitHistory.getPrescription());
            statement.setString(4, visitHistory.getVisitNotes());
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    @Override
    public VisitHistory findById(int visitId) {
        return findOne("SELECT * FROM visit_history WHERE visit_id = ?", visitId);
    }

    @Override
    public VisitHistory findByAppointmentId(int appointmentId) {
        return findOne("SELECT * FROM visit_history WHERE appointment_id = ?", appointmentId);
    }

    @Override
    public List<VisitHistory> findAll() {
        List<VisitHistory> visits = new ArrayList<>();
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                visits.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Visit history list failed: " + e.getMessage());
        }
        return visits;
    }

    @Override
    public boolean update(VisitHistory visitHistory) {
        String sql = """
                UPDATE visit_history
                SET diagnosis = ?, prescription = ?, visit_notes = ?
                WHERE visit_id = ?
                """;
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, visitHistory.getDiagnosis());
            statement.setString(2, visitHistory.getPrescription());
            statement.setString(3, visitHistory.getVisitNotes());
            statement.setInt(4, visitHistory.getVisitId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Visit history update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int visitId) {
        String sql = "DELETE FROM visit_history WHERE visit_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, visitId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Visit history delete failed: " + e.getMessage());
            return false;
        }
    }

    private VisitHistory findOne(String sql, int id) {
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Visit history lookup failed: " + e.getMessage());
            return null;
        }
    }

    private VisitHistory map(ResultSet resultSet) throws SQLException {
        VisitHistory visitHistory = new VisitHistory();
        visitHistory.setVisitId(resultSet.getInt("visit_id"));
        visitHistory.setAppointmentId(resultSet.getInt("appointment_id"));
        visitHistory.setDiagnosis(resultSet.getString("diagnosis"));
        visitHistory.setPrescription(resultSet.getString("prescription"));
        visitHistory.setVisitNotes(resultSet.getString("visit_notes"));
        return visitHistory;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
