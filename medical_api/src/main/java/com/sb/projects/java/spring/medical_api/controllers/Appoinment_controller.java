package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Appoinments;
import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.repos.Appoinment_repo;
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
    private Appoinment_repo appoinment_repo;

    @PostMapping("/new")
    public Appoinments addAppoinment(@RequestBody Appoinments appoinment) {
        return appoinment_repo.save(appoinment);
    }
}
