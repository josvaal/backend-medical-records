package com.josval.backend.model.dao;

import com.josval.backend.model.entity.Prescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionDAO extends CrudRepository<Prescription, Integer> {
    List<Prescription> findAllByMedicalHistoryId(Integer medicalHistoryId);
}
