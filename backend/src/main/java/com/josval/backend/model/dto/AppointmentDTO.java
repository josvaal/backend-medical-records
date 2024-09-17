package com.josval.backend.model.dto;

import com.josval.backend.model.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class AppointmentDTO implements Serializable {
    private Integer id;
    private User patient;
    private User doctor;
    private Date date;
    private String reason;
}
