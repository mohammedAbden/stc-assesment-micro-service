package com.stc.clinic_microservice.controllers;



import com.stc.clinic_microservice.exception.NotFoundException;
import com.stc.clinic_microservice.model.dto.CancelReason;
import com.stc.clinic_microservice.model.entities.Appointment;
import com.stc.clinic_microservice.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

   @GetMapping("/now")
    public List<Appointment> getTodayAppointments(){
       return appointmentService.getTodayAppointments();
    }

    @GetMapping("/")
    public List<Appointment> getAppointments(@RequestParam(required = true, name = "date") String date) throws ParseException {
        return appointmentService.getAppointments(date);
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<Appointment> addAppointment(@PathVariable(value = "patientId") Long patientId, @RequestBody Appointment appointment ) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointments(patientId,appointment)) ;
    }

    @PutMapping("/cancel/{id}")
   public ResponseEntity cancelAppointment(@PathVariable(value = "id") Long appointmentId,@RequestBody CancelReason cancelReason) throws NotFoundException {
        appointmentService.cancelAppointment(appointmentId, cancelReason);
        return ResponseEntity.ok().build();
    }


}
