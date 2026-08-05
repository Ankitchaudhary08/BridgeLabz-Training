package com.clinic.dao;

import com.clinic.dto.Doctor;

import java.util.List;

public interface DoctorDAO {
    int create(Doctor doctor);

    Doctor findById(int doctorId);

    List<Doctor> findAll();

    boolean update(Doctor doctor);

    boolean delete(int doctorId);

    boolean assignSpecialization(int doctorId, int specializationId);
}
