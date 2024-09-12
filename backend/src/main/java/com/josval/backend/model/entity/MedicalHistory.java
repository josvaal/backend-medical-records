package com.josval.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicalHistory;

    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id"
    )
    private User patientId;

    @ManyToOne
    @JoinColumn(
            name = "doctor_id",
            referencedColumnName = "id"
    )
    private User doctorId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;
}
