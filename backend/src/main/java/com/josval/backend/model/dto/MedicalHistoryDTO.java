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
public class MedicalHistoryDTO implements Serializable {
    private Integer idMedicalHistory;
    private User patientId;
    private User doctorId;
    private Date date;
    private String diagnosis;
    private String treatment;
}
