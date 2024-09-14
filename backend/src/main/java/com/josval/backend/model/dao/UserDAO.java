package com.josval.backend.model.dao;

import com.josval.backend.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
