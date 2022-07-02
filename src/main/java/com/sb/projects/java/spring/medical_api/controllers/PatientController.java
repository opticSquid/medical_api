package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import com.sb.projects.java.spring.medical_api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
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
        model.put("title", "Patients");
        model.put("patients", patientsList);
        Patients default_patient = new Patients();
        model.put("newPatient", default_patient);
        model.put("PatinetpopUp_hidden", "none");
        return "patients";
    }

    @RequestMapping(value = "/patients/new", method = RequestMethod.POST)
    public String addNewPatientController(HttpServletRequest request, ModelMap model, @Valid Patients patient, BindingResult result) {
        String contextURI = getCurrentContextURI(request);
        if (!result.hasErrors()) {
            Boolean created = patientService.addNewPatient(contextURI, patient);
            model.put("newPatientpopUp_hidden", "block");

            if (created) {
                model.put("toast_message_body", "New Patient Added to the database");
                model.put("toast_message_title", "Patient Added");
            } else {
                model.put("toast_message_body", "New Patient could not be added");
                model.put("toast_message_title", "Try Again");
            }
        }
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients/edit/{id}", method = RequestMethod.GET)
    public String editPatientDetails(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap model) {
        Patients patient_2B_edited = patientService.fetchPatientDetailsById(id, getCurrentContextURI(request));
        model.put("title", "Edit Patient Details");
        model.put("patient_edit", patient_2B_edited);
        //Required to set it explicitly otherwise it gets set to 0
        patient_2B_edited.setP_id(id);
        return "edit_patient";
    }

    @RequestMapping(value = "/patients/edit/{id}/save", method = RequestMethod.POST)
    public String submitEditedPatientDetails(@PathVariable("id") Integer id, HttpServletRequest request, @Valid Patients patient, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/patients/edit/" + patient.getP_id();
        }
        // Again setting it explicitly otherwise gets set to 0
        patient.setP_id(id);
        Boolean edit_success = patientService.editPatientDetails(patient, getCurrentContextURI(request));
        System.out.println("Edit Status: " + edit_success);
        //TODO: Need to alert user visually when edit was not successful
        return edit_success ? "redirect:/patients" : "redirect:/patients/edit/" + patient.getP_id();
    }

    @RequestMapping(value = "/patients/search/{by}", method = RequestMethod.POST)
    public String searchPatient(@PathVariable(value = "by", required = false) String by, @RequestParam String query, HttpServletRequest request, ModelMap model) {
        model.clear();
        model.put("title", "Patients");
        switch (by) {
            case "id":
                try {
                    Integer id = Integer.parseInt(query);
                    Patients patient = patientService.fetchPatientDetailsById(id, getCurrentContextURI(request));
                    List<Patients> patients_list_id = new ArrayList<>();
                    patients_list_id.add(patient);
                    System.out.println("Patient found: " + patients_list_id);
                    model.put("patients", patients_list_id);
                } catch (NumberFormatException e) {
                    System.out.println("Patient found: " + null);
                    model.put("patients", null);
                }
                break;
            case "email":
                Patients patient = patientService.fetchPatientDetailsByEmail(query, getCurrentContextURI(request));
                List<Patients> patient_list_email = new ArrayList<>();
                patient_list_email.add(patient);
                System.out.println("Patient found by email: \n" + patient_list_email);
                model.put("patients", patient_list_email);
                break;
            default:
                // default is search by name
                List<Patients> patient_list_name = patientService.fetchPatientDetailsByName(query, getCurrentContextURI(request));
                System.out.println("Patient found by name: \n" + patient_list_name);
                model.put("patients", patient_list_name);
        }
        model.put("newPatient", new Patients());
        model.put("patientpopUp_hidden", "none");
        return "patients";
    }
}
