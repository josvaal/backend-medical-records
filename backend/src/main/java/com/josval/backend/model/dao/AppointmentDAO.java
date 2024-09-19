package com.josval.backend.model.dao;

import com.josval.backend.model.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentDAO extends CrudRepository<Appointment, Integer> {
    List<Appointment> findAllByUserId(Integer userId);
}
