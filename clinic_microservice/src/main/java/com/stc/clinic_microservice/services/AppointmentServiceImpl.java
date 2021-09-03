package com.stc.clinic_microservice.services;


import com.stc.clinic_microservice.constant.AppointmentStatus;
import com.stc.clinic_microservice.constant.Constants;
import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.dto.CancelReason;
import com.stc.clinic_microservice.model.entities.Appointment;
import com.stc.clinic_microservice.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT);

    private final AppointmentRepository appointmentRepository;

    private final PatientService patientService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }

    @Override
    public List<Appointment> getTodayAppointments() {
        return appointmentRepository.findByAppointmentDate(LocalDate.now());
    }

    @Override
    public Appointment addAppointments(Long patientId, Appointment appointment) throws NotFoundException {
        appointment.setPatientId(patientId);
        appointment.setStatus(AppointmentStatus.ACTIVE.toString());
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(Long appointmentId, CancelReason cancelReason ) throws NotFoundException {
        Appointment Appointment =  getAppointment(appointmentId);
        Appointment.setStatus(AppointmentStatus.CANCEL.toString());
        Appointment.setCancellationReason(cancelReason.getCancelReason());
        appointmentRepository.save(Appointment);
    }

    @Override
    public Appointment getAppointment(Long appointmentId) throws NotFoundException {
        return appointmentRepository.findById(appointmentId).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Appointment> getAppointments(String date)  {
       return appointmentRepository.findByAppointmentDate(LocalDate.parse(date));
    }


}
