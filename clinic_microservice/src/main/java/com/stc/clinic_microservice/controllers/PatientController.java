package com.stc.clinic_microservice.controllers;


import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.entities.Appointment;
import com.stc.clinic_microservice.model.entities.Patient;
import com.stc.clinic_microservice.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatient(patient)) ;
    }

    @GetMapping("/appointment-history/{patientId}")
    public List<Appointment> getAppointmentHistory(@PathVariable Long patientId) throws NotFoundException {
        return patientService.getPatient(patientId).getAppointments();
    }

    @GetMapping("/appointment/by-name/{patientName}")
    public List<Appointment> getAppointmentHistory(@PathVariable String patientName) throws NotFoundException {
        return patientService.getPatientByName(patientName).getAppointments();
    }

}
