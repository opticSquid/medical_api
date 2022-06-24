package com.sb.projects.java.spring.medical_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class DoctorService {
    private final String url = "/api/doctors";
    @Autowired
    private RestTemplate restTemplate;

    public String getAllDoctors(String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(currentContext+url, HttpMethod.GET, entity, String.class).getBody();
    }
}
