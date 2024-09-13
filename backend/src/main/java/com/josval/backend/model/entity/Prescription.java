package com.josval.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "medical_history_id",
            referencedColumnName = "id"
    )
    private MedicalHistory medicalHistoryId;

    @Column(name = "medication")
    private String medication;

    @Column(name = "dose")
    private String dose;

    @Column(name = "duration")
    private String duration;
}
