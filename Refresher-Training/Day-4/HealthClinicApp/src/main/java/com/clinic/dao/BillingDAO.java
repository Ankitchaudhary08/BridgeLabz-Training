package com.clinic.dao;

import com.clinic.dto.Billing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillingDAO {
    int create(Billing billing);

    int create(Connection connection, Billing billing) throws SQLException;

    Billing findById(int billId);

    Billing findByAppointmentId(int appointmentId);

    List<Billing> findAll();

    boolean update(Billing billing);

    boolean delete(int billId);
}
