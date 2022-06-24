package com.sb.projects.java.spring.medical_api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.projects.java.spring.medical_api.entities.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        HttpEntity<String> entity = new HttpEntity<String>(headers);
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
        if (response.getStatusCodeValue() != 201) {
            return false;
        } else {
            return true;
        }
    }
}
