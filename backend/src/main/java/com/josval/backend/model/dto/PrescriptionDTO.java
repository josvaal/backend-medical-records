package com.josval.backend.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class PrescriptionDTO implements Serializable {
    private Integer id;
    private MedicalHistoryDTO medicalHistory;
    private String medication;
    private String dose;
    private String duration;
    private Date createdAt;
    private Date updatedAt;
}
