package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    private String getCurrentContextURI(HttpServletRequest request) {
        return ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).toUriString();
    }
    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String showAllPatients(HttpServletRequest request, ModelMap model) {
        String contextURI = getCurrentContextURI(request);
        List<Patients> patientsList = patientService.getAllPatients(contextURI);
        model.put("title","Patients");
        model.put("patients",patientsList);
        Patients default_patient = new Patients();
        model.put("newPatient",default_patient);
        model.put("PatinetpopUp_hidden", "none");
        return "patients";
    }
}
