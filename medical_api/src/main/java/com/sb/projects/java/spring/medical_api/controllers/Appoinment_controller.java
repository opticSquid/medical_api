package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.services.Appoinment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appoinment")
public class Appoinment_controller {
    @Autowired
    private Appoinment_service appoinment_service;

    @PostMapping("/add")
    public Patients addAppoinment(@RequestBody Patients patient) {
        return patient;
    }
}
