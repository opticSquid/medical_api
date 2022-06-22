package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Appointments;
import com.sb.projects.java.spring.medical_api.repos.Appointment_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appoinment")
public class Appointment_controller {
    @Autowired
    private Appointment_repo appointment_repo;

    @GetMapping
    public Iterable<Appointments> getAllAppoinments() {
        return appointment_repo.findAll();
    }

    @GetMapping("/{id}")
    public Appointments getAppoinmentById(@PathVariable("id") Integer id) {
        Optional<Appointments> appoinments_Optional = appointment_repo.findById(id);
        return appoinments_Optional.orElse(null);
    }

    @PostMapping("/new")
    public Appointments addAppoinment(@RequestBody Appointments appoinment) {
        return appointment_repo.save(appoinment);
    }

    @PatchMapping("/update/{id}")
    public Appointments updateAppoinment(@PathVariable("id") Integer id, @RequestBody Appointments appoinment) {
        Optional<Appointments> appoinment_optional = appointment_repo.findById(id);
        if (appoinment_optional.orElse(null) != null) {
            return appointment_repo.save(appoinment);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppoinment(@PathVariable("id") Integer id) {
        appointment_repo.deleteById(id);
    }
}
