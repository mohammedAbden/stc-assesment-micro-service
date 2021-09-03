package com.stc.clinic_microservice.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;
    private String status;
    private LocalDate appointmentDate;
    private String cancellationReason;
    private String description;

}
