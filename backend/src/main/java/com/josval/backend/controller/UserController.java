package com.josval.backend.controller;

import com.josval.backend.controller.mapper.UserMapper;
import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import com.josval.backend.model.payload.MessageResponse;
import com.josval.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @GetMapping("users")
    public ResponseEntity<?> showAll() {
        List<User> getUsers = userService.listAll();
        if (getUsers == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("No records found")
                    .object(null)
                    .build(),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Success")
                .object(getUsers)
                .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("user")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        try {
            User userSave = userService.save(userDTO);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Save successfully")
                    .object(userMapper.toUserDTO(userSave))
                    .build(),
                    HttpStatus.CREATED
            );
        }catch (DataAccessException e){
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(e.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }
}
