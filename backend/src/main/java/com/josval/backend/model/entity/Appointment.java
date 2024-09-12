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
@Table(name = "appointments")
public class Appointment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppointment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private User patientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private User doctorId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "appointment_date")
    private Date date;

    @Column(name = "reason")
    private String reason;
}
