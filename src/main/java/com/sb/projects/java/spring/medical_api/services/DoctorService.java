package com.sb.projects.java.spring.medical_api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.projects.java.spring.medical_api.entities.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {
    private final String url = "/api/doctors";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RestTemplate restTemplate;

    private List<Doctors> convertJsonToObj(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, new TypeReference<List<Doctors>>() {
        });
    }

    public List<Doctors> getAllDoctors(String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String JsonString = restTemplate.exchange(currentContext + url, HttpMethod.GET, entity, String.class).getBody();
        List<Doctors> doctorsList;
        try {
            doctorsList = convertJsonToObj(JsonString);
        } catch (JsonProcessingException e) {
            doctorsList = null;
        }
        return doctorsList;
    }

    public Boolean addNewDoctor(String currentContext, Doctors doctor) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Doctors> entity = new HttpEntity<>(doctor, headers);
        ResponseEntity<String> response = this.restTemplate.exchange(currentContext + url + "/new", HttpMethod.POST, entity, String.class);
        return response.getStatusCodeValue() == 201;
    }

    public Doctors fetchDoctorDetailsById(Integer id, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return restTemplate.getForObject(currentContext + url + "/id/" + id.toString(), Doctors.class);
    }

    public List<Doctors> fetchDoctorDetailsByName(String name, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<Doctors[]> doctors_list_response = restTemplate.getForEntity(currentContext + url + "/name/" + name, Doctors[].class);
        if (doctors_list_response.getBody() != null) {
            return Arrays.asList(doctors_list_response.getBody());
        } else {
            return null;
        }
    }

    public List<Doctors> fetchDoctorDetailsBySpecialization(String specz, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<Doctors[]> doctors_list_response = restTemplate.getForEntity(currentContext + url + "/specz/" + specz, Doctors[].class);
        if (doctors_list_response.getBody() != null) {
            return Arrays.asList(doctors_list_response.getBody());
        } else {
            return null;
        }
    }

    public Boolean editDoctorDetails(Doctors doctor, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Doctors> entity = new HttpEntity<>(doctor, headers);
        ResponseEntity<String> response = this.restTemplate.exchange(currentContext + url + "/update/" + doctor.getD_id(), HttpMethod.PUT, entity, String.class);
        return response.getStatusCodeValue() == 204;
    }

    public void deleteDoctor(Integer id, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        restTemplate.delete(currentContext+url+"/delete/"+id);
    }
}
