package com.clinic.dao;

import com.clinic.dto.Patient;

import java.util.List;

public interface PatientDAO {
    int create(Patient patient);

    Patient findById(int patientId);

    List<Patient> findAll();

    boolean update(Patient patient);

    boolean delete(int patientId);
}
