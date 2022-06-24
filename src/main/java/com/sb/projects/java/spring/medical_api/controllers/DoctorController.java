package com.sb.projects.java.spring.medical_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DoctorController {
    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorController(ModelMap model){
        model.put("title","Doctors");
        return "doctors";
    }
}
