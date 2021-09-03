package com.stc.clinic_microservice.repositories;


import com.stc.clinic_microservice.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    public List<Appointment> findByAppointmentDate(LocalDate date);

}
