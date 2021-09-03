package com.stc.clinic_microservice.services;



import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.dto.CancelReason;
import com.stc.clinic_microservice.model.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getTodayAppointments();

    Appointment addAppointments(Long patientId, Appointment appointment) throws NotFoundException;

    void cancelAppointment(Long appointmentId, CancelReason cancelReason) throws NotFoundException;

    Appointment getAppointment(Long appointmentId) throws NotFoundException;

    List<Appointment> getAppointments(String date);
}
