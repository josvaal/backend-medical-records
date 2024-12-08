package com.josval.backend.model.dao;

import com.josval.backend.model.entity.MedicalHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicalHistoryDAO extends CrudRepository<MedicalHistory, Integer> {
    List<MedicalHistory> findAllByPatientId(Integer patientId);
    List<MedicalHistory> findAllByDoctorId(Integer doctorId);
}
