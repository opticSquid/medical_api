package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Patient_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class Patient_controller {
    @Autowired
    private Patient_repo patient_repo;

    @GetMapping
    public Iterable<Patients> getPatients() {
        return patient_repo.findAll();
    }

    @GetMapping("/{id}")
    public Patients getPatientsById(@PathVariable("id") Integer id) {
        Optional<Patients> patient_optional = patient_repo.findById(id);
        return patient_optional.orElse(null);
    }

    @PostMapping(value = "/new")
    public Patients registerNewPatient(@RequestBody Patients patient) {
        return patient_repo.save(patient);
    }

    @PatchMapping(value = "/update/{id}")
    public Patients updatePatientDetails(@PathVariable("id") Integer id, @RequestBody Patients patient) {
        Optional<Patients> patient_optional = patient_repo.findById(id);
        if (patient_optional.orElse(null) != null) {
            return patient_repo.save(patient);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Integer id) {
        patient_repo.deleteById(id);
    }
}
