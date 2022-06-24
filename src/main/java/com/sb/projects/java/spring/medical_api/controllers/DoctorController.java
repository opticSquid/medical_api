package com.sb.projects.java.spring.medical_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.projects.java.spring.medical_api.entities.Doctors;
import com.sb.projects.java.spring.medical_api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorController(HttpServletRequest request, ModelMap model) throws JsonProcessingException {
       String currentContext =  ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).toUriString();
        String doctors_json = doctorService.getAllDoctors(currentContext);
        List<Doctors> doctorList = objectMapper.readValue(doctors_json, new TypeReference<List<Doctors>>(){});
        model.put("doctors",doctorList);
        model.put("title", "Doctors");
        return "doctors";
    }
}
