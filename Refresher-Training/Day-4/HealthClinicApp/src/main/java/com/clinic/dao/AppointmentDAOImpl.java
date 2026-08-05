package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public int create(Appointment appointment) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setFields(statement, appointment);
            statement.executeUpdate();
            return generatedId(statement);
        } catch (SQLException e) {
            System.out.println("Appointment create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public Appointment findById(int appointmentId) {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Appointment lookup failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Appointment> findAll() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments ORDER BY appointment_date, appointment_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                appointments.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Appointment list failed: " + e.getMessage());
        }
        return appointments;
    }

    @Override
    public boolean update(Appointment appointment) {
        String sql = """
                UPDATE appointments
                SET patient_id = ?, doctor_id = ?, appointment_date = ?, status = ?
                WHERE appointment_id = ?
                """;
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setFields(statement, appointment);
            statement.setInt(5, appointment.getAppointmentId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Appointment update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateStatus(int appointmentId, String status) {
        try (Connection connection = HikariConnectionPool.getConnection()) {
            return updateStatus(connection, appointmentId, status);
        } catch (SQLException e) {
            System.out.println("Appointment status update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateStatus(Connection connection, int appointmentId, String status) throws SQLException {
        String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, appointmentId);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int appointmentId) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointmentId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Appointment delete failed: " + e.getMessage());
            return false;
        }
    }

    private void setFields(PreparedStatement statement, Appointment appointment) throws SQLException {
        statement.setInt(1, appointment.getPatientId());
        statement.setInt(2, appointment.getDoctorId());
        statement.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
        statement.setString(4, appointment.getStatus() == null || appointment.getStatus().isBlank()
                ? "Scheduled" : appointment.getStatus());
    }

    private Appointment map(ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(resultSet.getInt("appointment_id"));
        appointment.setPatientId(resultSet.getInt("patient_id"));
        appointment.setDoctorId(resultSet.getInt("doctor_id"));
        appointment.setAppointmentDate(resultSet.getTimestamp("appointment_date").toLocalDateTime());
        appointment.setStatus(resultSet.getString("status"));
        return appointment;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
