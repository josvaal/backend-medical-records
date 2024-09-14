package com.josval.backend.service;

import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> listAll();
    User save(UserDTO userDTO);
    User findById(Integer id);
    User findByEmail(String email);
    void delete(User user);
    boolean existsById(Integer id);
}