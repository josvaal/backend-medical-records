package com.josval.backend.service;

import com.josval.backend.model.dto.PrescriptionDTO;
import com.josval.backend.model.entity.Prescription;

import java.util.List;

public interface IPrescriptionService {
    List<Prescription> listAll();
    Prescription save(PrescriptionDTO prescriptionDTO);
    Prescription findById(Integer id);
    List<Prescription> listAllByMedicalHistoryId(Integer medicalHistoryId);
    void delete(Prescription prescription);
    boolean existsById(Integer id);
}
