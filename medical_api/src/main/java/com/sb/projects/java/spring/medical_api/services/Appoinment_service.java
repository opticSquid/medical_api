package com.sb.projects.java.spring.medical_api.services;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Doctor_repo;
import com.sb.projects.java.spring.medical_api.repos.Patient_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Appoinment_service {
    @Autowired
    private Patient_repo patient_repo;
    @Autowired
    private Doctor_repo doctor_repo;


}
