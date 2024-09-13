package com.josval.backend.model.dao;

import com.josval.backend.model.entity.MedicalHistory;
import org.springframework.data.repository.CrudRepository;

public interface MedicalHistoryDAO extends CrudRepository<MedicalHistory, Integer> {
}
