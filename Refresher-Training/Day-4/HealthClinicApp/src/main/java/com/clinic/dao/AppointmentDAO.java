package com.clinic.dao;

import com.clinic.dto.Appointment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AppointmentDAO {
    int create(Appointment appointment);

    Appointment findById(int appointmentId);

    List<Appointment> findAll();

    boolean update(Appointment appointment);

    boolean updateStatus(int appointmentId, String status);

    boolean updateStatus(Connection connection, int appointmentId, String status) throws SQLException;

    boolean delete(int appointmentId);
}
