package com.josval.backend.service;

import com.josval.backend.model.dto.MedicalHistoryDTO;
import com.josval.backend.model.entity.MedicalHistory;

import java.util.List;

public interface IMedicalHistoryService {
    List<MedicalHistory> listAll();
    List<MedicalHistory> listAllByPatientId(Integer patientId);
    List<MedicalHistory> listAllByDoctorId(Integer doctorId);
    MedicalHistory save(MedicalHistoryDTO medicalHistoryDTO);
    MedicalHistory findById(Integer id);
    void delete(MedicalHistory medicalHistory);
    boolean existsById(Integer id);
}
