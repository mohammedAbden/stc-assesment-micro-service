package com.stc.clinic_microservice.services;


import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.entities.Patient;

public interface PatientService {

    Patient addPatient(Patient patient);

    Patient getPatient(Long patientId) throws NotFoundException;

    Patient getPatientByName(String patientName) throws NotFoundException;
}
