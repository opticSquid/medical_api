package com.sb.projects.java.spring.medical_api.controllers.api;

import com.sb.projects.java.spring.medical_api.entities.Appointments;
import com.sb.projects.java.spring.medical_api.repos.Appointment_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class Appointment_REST_controller {
    @Autowired
    private Appointment_repo appointment_repo;

    @GetMapping
    public Iterable<Appointments> getAllAppointments() {
        return appointment_repo.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable("id") Integer id) {
        Optional<Appointments> appointments_Optional = appointment_repo.findById(id);
        Appointments appointment =appointments_Optional.orElse(null);
        if(appointment!=null) {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Appointments> addAppointment(@RequestBody Appointments appointment) {
        Appointments new_appointment = appointment_repo.save(appointment);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/appoinments/{id}").buildAndExpand(new_appointment.getApmnt_id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointments> updateAppointment(@PathVariable("id") Integer id, @RequestBody Appointments appointment) {
        Optional<Appointments> appointment_optional = appointment_repo.findById(id);
        if (appointment_optional.orElse(null) != null) {
            Appointments updated_appointment = appointment_repo.save(appointment);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/appointments/{id}").buildAndExpand(updated_appointment.getApmnt_id()).toUri();
            return ResponseEntity.status(204).location(location).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") Integer id) {
        try {
            appointment_repo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
