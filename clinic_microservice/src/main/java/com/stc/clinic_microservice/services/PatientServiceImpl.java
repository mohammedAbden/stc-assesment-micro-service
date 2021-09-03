package com.stc.clinic_microservice.services;


import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.entities.Patient;
import com.stc.clinic_microservice.repositories.PatientRepository;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long patientId) throws NotFoundException {
        return patientRepository.findById(patientId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Patient getPatientByName(String patientName) throws NotFoundException {
        return patientRepository.findByName(patientName).orElseThrow(NotFoundException::new);
    }
}
