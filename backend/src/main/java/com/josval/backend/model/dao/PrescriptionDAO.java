package com.josval.backend.model.dao;

import com.josval.backend.model.entity.Prescription;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrescriptionDAO extends CrudRepository<Prescription, Integer> {
    Optional<Prescription> findByMedicalHistoryId(Integer medicalHistoryId);
}
