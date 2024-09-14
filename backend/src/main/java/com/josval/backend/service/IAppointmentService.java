package com.josval.backend.service;

import com.josval.backend.model.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> listAll();
    List<Appointment> listAllByUserId(Integer id);
    Sale save(SaleDTO sale);
    Sale findById(Integer id);
    void delete(Sale sale);
    boolean existsById(Integer id);
}
