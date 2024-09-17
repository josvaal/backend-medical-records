package com.josval.backend.service.impl;

import com.josval.backend.model.dao.MedicalHistoryDAO;
import com.josval.backend.model.dto.MedicalHistoryDTO;
import com.josval.backend.model.entity.MedicalHistory;
import com.josval.backend.service.IMedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalHistoryImplService implements IMedicalHistoryService {
    @Autowired
    private MedicalHistoryDAO medicalHistoryDAO;

    @Transactional(readOnly = true)
    @Override
    public List<MedicalHistory> listAll() {
        return (List<MedicalHistory>) medicalHistoryDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<MedicalHistory> listAllByPatientId(Integer patientId) {
        return medicalHistoryDAO.findAllByPatientId(patientId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MedicalHistory> listAllByDoctorId(Integer doctorId) {
        return medicalHistoryDAO.findAllByDoctorId(doctorId);
    }

    @Transactional
    @Override
    public MedicalHistory save(MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistory medicalHistory = MedicalHistory.builder()
                .id(medicalHistoryDTO.getId())
                .patient(medicalHistoryDTO.getPatient())
                .doctor(medicalHistoryDTO.getDoctor())
                .date(medicalHistoryDTO.getDate())
                .diagnosis(medicalHistoryDTO.getDiagnosis())
                .treatment(medicalHistoryDTO.getTreatment())
                .build();
        return medicalHistoryDAO.save(medicalHistory);
    }

    @Transactional(readOnly = true)
    @Override
    public MedicalHistory findById(Integer id) {
        return medicalHistoryDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(MedicalHistory medicalHistory) {
        medicalHistoryDAO.delete(medicalHistory);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return medicalHistoryDAO.existsById(id);
    }
}
