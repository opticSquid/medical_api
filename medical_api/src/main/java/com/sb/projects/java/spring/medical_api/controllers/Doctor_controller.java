package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.repos.Doctor_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class Doctor_controller {
    @Autowired
    Doctor_repo doctor_repo;

    @GetMapping
    public Iterable<Doctors> getDoctors() {
        return doctor_repo.findAll();
    }

    @GetMapping("/{id}")
    public Doctors getDoctorById(@PathVariable("id") int id) {
        Optional<Doctors> doctor_optional = doctor_repo.findById(id);
        return doctor_optional.orElse(null);
        // Above line is the one liner for the lines below
//        if(doctor_optional.isPresent()) {
//            return doctor_optional.get();
//        } else {
//            return null;
//        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Doctors registerNewDoctor(@RequestBody Doctors doctor) {
        return doctor_repo.save(doctor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Doctors updateDoctorDetails(@PathVariable("id") int id, @RequestBody Doctors doctor) {
        Optional<Doctors> doctor_optional = doctor_repo.findById(id);
        if (doctor_optional.orElse(null) != null) {
            return doctor_repo.save(doctor);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id") int id) {
        doctor_repo.deleteById(id);
    }
}
