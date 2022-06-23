package com.sb.projects.java.spring.medical_api.controllers.api;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.repos.Doctor_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class Doctor_controller {
    @Autowired
    private Doctor_repo doctor_repo;

    @GetMapping
    public Iterable<Doctors> getDoctors() {
        return doctor_repo.findAll();
    }

    @GetMapping("/{id}")
    public Doctors getDoctorById(@PathVariable("id") Integer id) {
        Optional<Doctors> doctor_optional = doctor_repo.findById(id);
        return doctor_optional.orElse(null);
        // Above line is the one liner for the lines below
//        if(doctor_optional.isPresent()) {
//            return doctor_optional.get();
//        } else {
//            return null;
//        }
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Doctors> registerNewDoctor(@RequestBody Doctors doctor) {
        Doctors saved_doctor =doctor_repo.save(doctor);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/doctors/{id}").buildAndExpand(saved_doctor.getD_id()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Doctors> updateDoctorDetails(@PathVariable("id") Integer id, @RequestBody Doctors doctor) {
        Optional<Doctors> doctor_optional = doctor_repo.findById(id);
        if (doctor_optional.orElse(null) != null) {
            Doctors updated_doctor=doctor_repo.save(doctor);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/doctors/{id}").buildAndExpand(updated_doctor.getD_id()).toUri();
            return ResponseEntity.status(204).location(location).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id) {
        try{
            doctor_repo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
