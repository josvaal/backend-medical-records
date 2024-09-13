package com.josval.backend.model.dao;

import com.josval.backend.model.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentDAO extends CrudRepository<Appointment, Integer> {
}
