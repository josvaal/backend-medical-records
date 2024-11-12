package com.josval.backend.model.dto;

import com.josval.backend.model.enums.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class RegisterDTO implements Serializable {
    private String firstname;
    private String lastname;
    private String dni;
    private String password;
    private UserRole userRole;
    private Date dateOfBirth;
    private String phone;
    private String address;
}
