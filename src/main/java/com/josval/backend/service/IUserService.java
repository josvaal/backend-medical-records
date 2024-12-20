package com.josval.backend.service;

import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import com.josval.backend.model.enums.UserRole;

import java.util.List;

public interface IUserService {
    List<User> listAll();

    User save(UserDTO userDTO);

    User findById(Integer id);

    User findByDni(String dni);

    List<User> findAllByUserRole(UserRole userRole);

    void delete(User user);

    boolean existsById(Integer id);
}