package com.josval.backend.model.dto;

import com.josval.backend.model.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder
@ToString
public class AppointmentDTO {
    private Integer idAppointment;
    private User patientId;
    private User doctorId;
    private Date date;
    private String reason;
}
