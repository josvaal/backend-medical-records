package com.josval.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "medical_history")
public class MedicalHistory implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            foreignKey = @ForeignKey(name = "fk_medical_history_patient")
    )
    private User patient;

    @ManyToOne
    @JoinColumn(
            name = "doctor_id",
            foreignKey = @ForeignKey(name = "fk_medical_history_doctor")
    )
    private User doctor;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;
}
