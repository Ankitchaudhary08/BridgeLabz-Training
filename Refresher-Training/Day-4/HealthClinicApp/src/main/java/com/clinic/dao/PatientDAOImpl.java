package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public int create(Patient patient) {
        String sql = """
                INSERT INTO patients (first_name, last_name, date_of_birth, gender, email)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setPatientFields(statement, patient);
            statement.executeUpdate();
            return generatedId(statement);
        } catch (SQLException e) {
            System.out.println("Patient create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public Patient findById(int patientId) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Patient lookup failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                patients.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Patient list failed: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public boolean update(Patient patient) {
        String sql = """
                UPDATE patients
                SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, email = ?
                WHERE patient_id = ?
                """;
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setPatientFields(statement, patient);
            statement.setInt(6, patient.getPatientId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Patient update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int patientId) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patientId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Patient delete failed: " + e.getMessage());
            return false;
        }
    }

    private void setPatientFields(PreparedStatement statement, Patient patient) throws SQLException {
        statement.setString(1, patient.getFirstName());
        statement.setString(2, patient.getLastName());
        if (patient.getDateOfBirth() == null) {
            statement.setNull(3, java.sql.Types.DATE);
        } else {
            statement.setDate(3, Date.valueOf(patient.getDateOfBirth()));
        }
        statement.setString(4, patient.getGender());
        statement.setString(5, patient.getEmail());
    }

    private Patient map(ResultSet resultSet) throws SQLException {
        Patient patient = new Patient();
        patient.setPatientId(resultSet.getInt("patient_id"));
        patient.setFirstName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        Date dob = resultSet.getDate("date_of_birth");
        patient.setDateOfBirth(dob == null ? null : dob.toLocalDate());
        patient.setGender(resultSet.getString("gender"));
        patient.setEmail(resultSet.getString("email"));
        Timestamp registeredOn = resultSet.getTimestamp("registered_on");
        patient.setRegisteredOn(registeredOn == null ? null : registeredOn.toLocalDateTime());
        return patient;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
