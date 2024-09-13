package com.josval.backend.model.dao;

import com.josval.backend.model.entity.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionsDAO extends CrudRepository<Prescription, Integer> {
}
