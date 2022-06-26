package com.sb.projects.java.spring.medical_api.controllers.api;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Patient_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class Patient_REST_controller {
    @Autowired
    private Patient_repo patient_repo;

    @GetMapping
    public Iterable<Patients> getPatients() {
        return patient_repo.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Patients> getPatientsById(@PathVariable("id") Integer id) {
        Optional<Patients> patient_optional = patient_repo.findById(id);
        Patients patient=patient_optional.orElse(null);
        if(patient!=null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Patients> registerNewPatient(@RequestBody Patients patient) {
        Patients saved_patient = patient_repo.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/patients/{id}").buildAndExpand(saved_patient.getP_id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Patients> updatePatientDetails(@PathVariable("id") Integer id, @RequestBody Patients patient) {
        Optional<Patients> patient_optional = patient_repo.findById(id);
        if (patient_optional.orElse(null) != null) {
            Patients updated_patient=patient_repo.save(patient);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/patients/{id}").buildAndExpand(updated_patient.getP_id()).toUri();
            return ResponseEntity.status(204).location(location).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Integer id) {
        try{
            patient_repo.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
