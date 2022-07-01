package com.sb.projects.java.spring.medical_api.services;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PatientService {
    private final String url = "/api/patients";
    private final HttpHeaders httpHeaders = new HttpHeaders();
    @Autowired
    private RestTemplate restTemplate;

    public List<Patients> getAllPatients(String context) {
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<Patients[]> patient_list_response = restTemplate.getForEntity(context + url, Patients[].class);
        if (patient_list_response.getBody() != null) {
            return Arrays.asList(patient_list_response.getBody());
        } else {
            return null;
        }
    }
}
