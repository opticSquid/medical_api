package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.services.DoctorService;
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
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    private String getCurrentContextURI(HttpServletRequest request) {
        return ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).toUriString();
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String showAllDoctors(HttpServletRequest request, ModelMap model) {
        model.put("title", "Doctors");
        // Returns http://localhost:8080 in an URI like http://localhost:8080/x/y/z
        String currentContextURI = getCurrentContextURI(request);
        List<Doctors> doctorList = doctorService.getAllDoctors(currentContextURI);
        model.put("doctors", doctorList);
        // Binding an instance of "doctors" class to the form. Initializing it below
        // This is for the form to add doctor
        Doctors default_newDoctor = new Doctors();
        default_newDoctor.setName("");
        default_newDoctor.setEmail("");
        default_newDoctor.setSpecialization("");
        default_newDoctor.setDegree("");
        model.put("newDoctor", default_newDoctor);
        model.put("DoctorpopUp_hidden", "none");
        return "doctors";
    }

    @RequestMapping(value = "/doctors/new", method = RequestMethod.POST)
    public String addNewDoctorController(HttpServletRequest request, ModelMap model, @Valid Doctors doctor, BindingResult result) {
        if (!result.hasErrors()) {
            Boolean created = doctorService.addNewDoctor(getCurrentContextURI(request), doctor);
            model.put("newDoctorpopUp_hidden", "block");
            if (created) {
                model.put("toast_message_body", "New Doctor Added to the database");
                model.put("toast_message_title", "Doctor Added");
            } else {
                model.put("toast_message_body", "New Doctor could not be added");
                model.put("toast_message_title", "Try Again");
            }
        }
        return "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/edit/{id}", method = RequestMethod.GET)
    public String editDoctorDetails(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap model) {
        Doctors doctor_2B_edited = doctorService.fetchDoctorDetailsById(id, getCurrentContextURI(request));
        model.put("title", "Edit Doctor Details");
        model.put("doctor_edit", doctor_2B_edited);
        //Required to set it explicitly otherwise it gets set to 0
        doctor_2B_edited.setD_id(id);
        return "edit_doctor";
    }

    @RequestMapping(value = "/doctors/edit/{id}/save", method = RequestMethod.POST)
    public String submitEditedDoctorDetails(@PathVariable("id") Integer id, HttpServletRequest request, @Valid Doctors doctor, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/doctors/edit/" + doctor.getD_id();
        }
        // Again setting it explicitly otherwise gets set to 0
        doctor.setD_id(id);
        Boolean edit_success = doctorService.editDoctorDetails(doctor, getCurrentContextURI(request));
        System.out.println("Edit Status: " + edit_success);
        //TODO: Need to alert user visually when edit was not successful
        return edit_success ? "redirect:/doctors" : "redirect:/doctors/edit/" + doctor.getD_id();
    }

    @RequestMapping(value = "/doctors/search/{by}", method = RequestMethod.POST)
    public String searchDoctor(@PathVariable(required = false) String by, @RequestParam String query, HttpServletRequest request, ModelMap model) {
        model.clear();
        System.out.println("Search");
        System.out.println("filter: " + by);
        System.out.println("Query: " + query);
        model.put("title", "Doctors");
        switch (by) {
            case "id":
                try {
                    Integer id = Integer.parseInt(query);
                    Doctors doctor = doctorService.fetchDoctorDetailsById(id, getCurrentContextURI(request));
                    List<Doctors> doctors_list_id = new ArrayList<>();
                    doctors_list_id.add(doctor);
                    System.out.println("Doctor found: " + doctors_list_id);
                    model.put("doctors", doctors_list_id);
                } catch (NumberFormatException e) {
                    System.out.println("Doctor found: " + null);
                    model.put("doctors", null);
                }
                break;
            case "specialization":
                List<Doctors> doctor_list_specz = doctorService.fetchDoctorDetailsBySpecialization(query, getCurrentContextURI(request));
                System.out.println("Doctor found by specialization: \n" + doctor_list_specz);
                model.put("doctors", doctor_list_specz);
                break;
            default:
                // default is search by name
                List<Doctors> doctor_list_name = doctorService.fetchDoctorDetailsByName(query, getCurrentContextURI(request));
                System.out.println("Doctor found by name: \n" + doctor_list_name);
                model.put("doctors", doctor_list_name);
        }
        model.put("newDoctor", new Doctors());
        model.put("DoctorpopUp_hidden", "none");
        return "doctors";
    }

    @RequestMapping(value = "/doctors/delete/{d_id}", method = RequestMethod.GET)
    public String deleteDoctor(@PathVariable("d_id") Integer d_id, HttpServletRequest request) {
        doctorService.deleteDoctor(d_id, getCurrentContextURI(request));
        return "redirect:/doctors";
    }
}

