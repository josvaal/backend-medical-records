package com.josval.backend.service.impl;

import com.josval.backend.model.dao.AppointmentDAO;
import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.entity.Appointment;
import com.josval.backend.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentImplService implements IAppointmentService {
    @Autowired
    AppointmentDAO appointmentDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAll() {
        return (List<Appointment>) appointmentDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAllByPatientId(Integer patientId) {
        return appointmentDAO.findAllByPatientId(patientId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAllByDoctorId(Integer doctorId) {
        return appointmentDAO.findAllByDoctorId(doctorId);
    }

    @Transactional
    @Override
    public Appointment save(AppointmentDTO appointmentDTO) {
        Appointment appointment = Appointment.builder()
                .id(appointmentDTO.getId())
                .patient(appointmentDTO.getPatient())
                .doctor(appointmentDTO.getDoctor())
                .date(appointmentDTO.getDate())
                .reason(appointmentDTO.getReason())
                .build();
        return appointmentDAO.save(appointment);
    }

    @Transactional(readOnly = true)
    @Override
    public Appointment findById(Integer id) {
        return appointmentDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Appointment appointment) {
        appointmentDAO.delete(appointment);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return appointmentDAO.existsById(id);
    }
}
