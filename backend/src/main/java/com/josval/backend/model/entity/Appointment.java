package com.josval.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_appointment_patient"))
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "fk_appointment_doctor"))
    private User doctor;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "appointment_date")
    private Date date;

    @Column(name = "reason")
    private String reason;
}
