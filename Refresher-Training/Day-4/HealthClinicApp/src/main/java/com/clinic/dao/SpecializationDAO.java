package com.clinic.dao;

import com.clinic.dto.Specialization;

import java.util.List;

public interface SpecializationDAO {
    int create(Specialization specialization);

    Specialization findById(int specializationId);

    List<Specialization> findAll();

    boolean update(Specialization specialization);

    boolean delete(int specializationId);
}
