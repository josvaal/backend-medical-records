package com.josval.backend.model.dao;

import com.josval.backend.model.entity.User;
import com.josval.backend.model.enums.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Integer> {
    Optional<User> findByDni(String dni);

    List<User> findAllByUserRole(UserRole userRole);
}
