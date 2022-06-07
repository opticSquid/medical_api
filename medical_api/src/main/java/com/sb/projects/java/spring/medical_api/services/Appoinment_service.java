package com.sb.projects.java.spring.medical_api.services;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Doctor_repo;
import com.sb.projects.java.spring.medical_api.repos.Patient_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Appoinment_service {
    @Autowired
    private Patient_repo patient_repo;
    @Autowired
    private Doctor_repo doctor_repo;

    @Transactional
    public Patients create_appoinment(Patients patient) {
        try {
            patient_repo.save(patient);
        } catch (Error e) {
            System.out.println("Error while saving patient: " + e);
            return null;
        }
        try {
            int d_id = patient.getDoctor().getD_id();
            Optional<Doctors> doctor_optional = doctor_repo.findById(d_id);
            Doctors doctor = doctor_optional.orElse(null);
            if (doctor == null) {
                return null;
            } else {
                List<Patients> patients = doctor.getPatients();
                patients.add(patient);
                doctor_repo.save(doctor);
                return patient;
            }
        } catch (Error e) {
            System.out.println("Error while finding doctor : " + e);
            return null;
        }
    }
}
