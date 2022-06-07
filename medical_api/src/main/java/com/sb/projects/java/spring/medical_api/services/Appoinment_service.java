package com.sb.projects.java.spring.medical_api.services;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Doctor_repo;
import com.sb.projects.java.spring.medical_api.repos.Patient_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Appoinment_service {
    @Autowired
    private Patient_repo patient_repo;
    @Autowired
    private Doctor_repo doctor_repo;

    public Patients create_appoinment(Patients patient) {
        System.out.println("Incoming Patient: \n" + patient);
        Doctors doctor = patient.getDoctor();
        //Setting/Appending the list of patients in doctor entity
        List<Patients> patientList = doctor.getPatients() != null ? doctor.getPatients() : new ArrayList<>();
        Patients patient_tobe_added = new Patients();
        patient_tobe_added.setP_id(patient.getP_id());
        patient_tobe_added.setName(patient.getName());
        patient_tobe_added.setEmail(patient.getEmail());
        patient_tobe_added.setContact_no(patient.getContact_no());
        patientList.add(patient_tobe_added);
        doctor.setPatients(patientList);
        System.out.println("Outging Doctor: \n" + doctor);
        doctor_repo.save(doctor);
//        Doctors doctor_patient = patient.getDoctor();
//        doctor_patient.setPatients(null);
//        patient.setDoctor(doctor_patient);
        System.out.println("Outging Patient: \n" + patient);
        return patient_repo.save(patient);
    }
}
