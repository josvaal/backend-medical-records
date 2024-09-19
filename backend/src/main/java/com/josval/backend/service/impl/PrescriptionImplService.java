package com.josval.backend.service.impl;

import com.josval.backend.model.dao.PrescriptionDAO;
import com.josval.backend.model.dto.PrescriptionDTO;
import com.josval.backend.model.entity.Prescription;
import com.josval.backend.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrescriptionImplService implements IPrescriptionService {
    @Autowired
    PrescriptionDAO prescriptionDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Prescription> listAll() {
        return (List<Prescription>) prescriptionDAO.findAll();
    }

    @Transactional
    @Override
    public Prescription save(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = Prescription.builder()
                .id(prescriptionDTO.getId())
                .medicalHistory(prescriptionDTO.getMedicalHistory())
                .medication(prescriptionDTO.getMedication())
                .dose(prescriptionDTO.getDose())
                .duration(prescriptionDTO.getDuration())
                .build();
        return prescriptionDAO.save(prescription);
    }

    @Transactional(readOnly = true)
    @Override
    public Prescription findById(Integer id) {
        return prescriptionDAO.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Prescription> listAllByMedicalHistoryId(Integer medicalHistoryId) {
        return prescriptionDAO.findAllByMedicalHistoryId(medicalHistoryId);
    }

    @Transactional
    @Override
    public void delete(Prescription prescription) {
        prescriptionDAO.delete(prescription);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return prescriptionDAO.existsById(id);
    }
}
