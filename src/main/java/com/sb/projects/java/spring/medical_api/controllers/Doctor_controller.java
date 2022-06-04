package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Doctor;
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
    public Iterable<Doctor> getDoctors() {
        return doctor_repo.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorbyId(@PathVariable("id") int id) {
        Optional<Doctor> doctor_optional = doctor_repo.findById(id);
        return doctor_optional.orElse(null);
        // Above line is the one liner for the lines below
//        if(doctor_optional.isPresent()) {
//            return doctor_optional.get();
//        } else {
//            return null;
//        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Doctor registerNewDoctor(@RequestBody Doctor doctor) {
        return doctor_repo.save(doctor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Doctor updateDoctorDetails(@PathVariable("id") int id, @RequestBody Doctor doctor) {
        Optional<Doctor> doctor_optional = doctor_repo.findById(id);
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
