package com.sb.projects.java.spring.medical_api.controllers;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    private String getCurrentContextURI(HttpServletRequest request) {
        return ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).toUriString();
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorController(HttpServletRequest request, ModelMap model) {
        model.put("title", "Doctors");
        // Returns http://localhost:8080 in an URI like http://localhost:8080/x/y/z
        String currentContextURI = getCurrentContextURI(request);
        List<Doctors> doctorList = doctorService.getAllDoctors(currentContextURI);
        model.put("doctors", doctorList);
        // Binding an instance of "doctors" class to the form. Initializing it below
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
                model.put("toast_message_body","New Doctor Added to the database");
                model.put("toast_message_title","Doctor Added");
            } else {
                model.put("toast_message_body","New Doctor could not be added");
                model.put("toast_message_title","Try Again");
            }
        }
        return "redirect:/doctors";
    }
}
