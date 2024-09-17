package com.josval.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "prescriptions")
public class Prescription implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "medical_history_id",
            foreignKey = @ForeignKey(name = "fk_prescription_medical_history")
    )
    private MedicalHistory medicalHistory;

    @Column(name = "medication")
    private String medication;

    @Column(name = "dose")
    private String dose;

    @Column(name = "duration")
    private String duration;
}
