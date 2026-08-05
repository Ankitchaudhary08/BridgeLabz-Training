package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.AppointmentDAOImpl;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.BillingDAOImpl;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dao.VisitHistoryDAOImpl;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class AppointmentService {
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    public boolean completeAppointment(
            int appointmentId,
            BigDecimal amount,
            String diagnosis,
            String prescription,
            String notes
    ) {
        Connection connection = null;
        try {
            connection = HikariConnectionPool.getConnection();
            connection.setAutoCommit(false);

            boolean updated = appointmentDAO.updateStatus(connection, appointmentId, "Completed");
            if (!updated) {
                throw new SQLException("Appointment ID " + appointmentId + " was not found.");
            }

            Billing billing = new Billing(appointmentId, amount, "Pending");
            int billId = billingDAO.create(connection, billing);
            if (billId <= 0) {
                throw new SQLException("Bill was not created.");
            }

            VisitHistory visitHistory = new VisitHistory(appointmentId, diagnosis, prescription, notes);
            int visitId = visitHistoryDAO.create(connection, visitHistory);
            if (visitId <= 0) {
                throw new SQLException("Visit history was not created.");
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Complete appointment failed; rolling back: " + e.getMessage());
            rollback(connection);
            return false;
        } finally {
            close(connection);
        }
    }

    private void rollback(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println("Rollback failed: " + e.getMessage());
        }
    }

    private void close(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection close failed: " + e.getMessage());
        }
    }
}
