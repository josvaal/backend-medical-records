package com.josval.backend.service;

import com.josval.backend.model.dto.AppointmentDTO;
import com.josval.backend.model.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> listAll();
    List<Appointment> listAllByDoctorId(Integer doctorId);
    List<Appointment> listAllByPatientId(Integer patientId);
    Appointment save(AppointmentDTO appointment);
    Appointment findById(Integer id);
    void delete(Appointment appointment);
    boolean existsById(Integer id);
}
