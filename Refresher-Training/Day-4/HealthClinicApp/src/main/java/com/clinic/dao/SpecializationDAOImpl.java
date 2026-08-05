package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Specialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {
    @Override
    public int create(Specialization specialization) {
        String sql = "INSERT INTO specializations (name, description) VALUES (?, ?)";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, specialization.getName());
            statement.setString(2, specialization.getDescription());
            statement.executeUpdate();
            return generatedId(statement);
        } catch (SQLException e) {
            System.out.println("Specialization create failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public Specialization findById(int specializationId) {
        String sql = "SELECT * FROM specializations WHERE specialization_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, specializationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? map(resultSet) : null;
            }
        } catch (SQLException e) {
            System.out.println("Specialization lookup failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Specialization> findAll() {
        List<Specialization> specializations = new ArrayList<>();
        String sql = "SELECT * FROM specializations ORDER BY specialization_id";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                specializations.add(map(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Specialization list failed: " + e.getMessage());
        }
        return specializations;
    }

    @Override
    public boolean update(Specialization specialization) {
        String sql = "UPDATE specializations SET name = ?, description = ? WHERE specialization_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, specialization.getName());
            statement.setString(2, specialization.getDescription());
            statement.setInt(3, specialization.getSpecializationId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Specialization update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int specializationId) {
        String sql = "DELETE FROM specializations WHERE specialization_id = ?";
        try (Connection connection = HikariConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, specializationId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Specialization delete failed: " + e.getMessage());
            return false;
        }
    }

    private Specialization map(ResultSet resultSet) throws SQLException {
        Specialization specialization = new Specialization();
        specialization.setSpecializationId(resultSet.getInt("specialization_id"));
        specialization.setName(resultSet.getString("name"));
        specialization.setDescription(resultSet.getString("description"));
        return specialization;
    }

    private int generatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet keys = statement.getGeneratedKeys()) {
            return keys.next() ? keys.getInt(1) : -1;
        }
    }
}
