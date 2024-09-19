package com.josval.backend.service.impl;

import com.josval.backend.controller.mapper.AppointmentMapper;
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
    AppointmentMapper appointmentMapper;

    @Autowired
    AppointmentDAO appointmentDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAll() {
        return (List<Appointment>) appointmentDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAllByDoctorId(Integer doctorId) {
        return appointmentDAO.findAllByDoctorId(doctorId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> listAllByPatientId(Integer patientId) {
        return appointmentDAO.findAllByPatientId(patientId);
    }

    @Transactional
    @Override
    public Appointment save(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.toAppointment(appointmentDTO);
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
