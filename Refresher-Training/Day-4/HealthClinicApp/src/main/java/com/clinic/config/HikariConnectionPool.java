package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class HikariConnectionPool {
    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC";
    private static final HikariDataSource DATA_SOURCE = createDataSource();

    private HikariConnectionPool() {
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    private static HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(valueOrDefault("DB_URL", DEFAULT_URL));
        config.setUsername(valueOrDefault("DB_USER", "root"));
        config.setPassword(valueOrDefault("DB_PASSWORD", "root"));
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setPoolName("HealthClinicPool");
        return new HikariDataSource(config);
    }

    private static String valueOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
