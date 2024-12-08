package com.josval.backend.service.impl;

import com.josval.backend.controller.mapper.UserMapper;
import com.josval.backend.model.dao.UserDAO;
import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import com.josval.backend.model.enums.UserRole;
import com.josval.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserImplService implements IUserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public List<User> listAll() {
        return (List<User>) userDAO.findAll();
    }

    @Transactional
    @Override
    public User save(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);

        return userDAO.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return userDAO.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByDni(String dni) {
        return userDAO.findByDni(dni).orElse(null);
    }

    @Override
    public List<User> findAllByUserRole(UserRole userRole) {
        return userDAO.findAllByUserRole(userRole);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return userDAO.existsById(id);
    }
}
