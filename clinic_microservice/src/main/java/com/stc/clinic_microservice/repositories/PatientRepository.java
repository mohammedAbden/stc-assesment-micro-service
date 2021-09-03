package com.stc.clinic_microservice.repositories;


import com.stc.clinic_microservice.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    public Optional<Patient> findByName(String name);
}
