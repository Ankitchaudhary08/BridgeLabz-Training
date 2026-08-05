package com.clinic.dao;

import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitHistoryDAO {
    int create(VisitHistory visitHistory);

    int create(Connection connection, VisitHistory visitHistory) throws SQLException;

    VisitHistory findById(int visitId);

    VisitHistory findByAppointmentId(int appointmentId);

    List<VisitHistory> findAll();

    boolean update(VisitHistory visitHistory);

    boolean delete(int visitId);
}
