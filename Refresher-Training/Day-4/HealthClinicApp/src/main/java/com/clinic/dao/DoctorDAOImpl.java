package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public int create(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setFields(statement, doctor);
            statement.executeUpdate();
            return generatedId(statement);
        } catch (SQLException e) {
            System.out.println("Doctor create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public Doctor findById(int doctorId) {
        String sql = "SELECT * FROM doctors WHERE doctor_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Doctor lookup failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY doctor_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                doctors.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Doctor list failed: " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public boolean update(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, phone_number = ?, email = ? WHERE doctor_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setFields(statement, doctor);
            statement.setInt(5, doctor.getDoctorId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Doctor update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int doctorId) {
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Doctor delete failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assignSpecialization(int doctorId, int specializationId) {
        String sql = "INSERT IGNORE INTO doctor_specializations (doctor_id, specialization_id) VALUES (?, ?)";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            statement.setInt(2, specializationId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Specialization assignment failed: " + e.getMessage());
            return false;
        }
    }

    private void setFields(PreparedStatement statement, Doctor doctor) throws SQLException {
        statement.setString(1, doctor.getFirstName());
        statement.setString(2, doctor.getLastName());
        statement.setString(3, doctor.getPhoneNumber());
        statement.setString(4, doctor.getEmail());
    }

    private Doctor map(ResultSet resultSet) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(resultSet.getInt("doctor_id"));
        doctor.setFirstName(resultSet.getString("first_name"));
        doctor.setLastName(resultSet.getString("last_name"));
        doctor.setPhoneNumber(resultSet.getString("phone_number"));
        doctor.setEmail(resultSet.getString("email"));
        return doctor;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
