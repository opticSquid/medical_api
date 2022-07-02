package com.sb.projects.java.spring.medical_api.services;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    public Boolean addNewPatient(String currentContext, Patients patient) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Patients> entity = new HttpEntity<>(patient, httpHeaders);
        ResponseEntity<String> response = this.restTemplate.exchange(currentContext + url + "/new", HttpMethod.POST, entity, String.class);
        return response.getStatusCodeValue() == 201;
    }

    public Patients fetchPatientDetailsById(Integer id, String currentContext) {
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return restTemplate.getForObject(currentContext + url + "/id/" + id.toString(), Patients.class);
    }

    public List<Patients> fetchPatientDetailsByName(String name, String currentContext) {
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<Patients[]> patient_list_response = restTemplate.getForEntity(currentContext + url + "/name/" + name, Patients[].class);
        if (patient_list_response.getBody() != null) {
            return Arrays.asList(patient_list_response.getBody());
        } else {
            return null;
        }
    }

    public Patients fetchPatientDetailsByEmail (String email, String currentContext) {
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return restTemplate.getForObject(currentContext+url+"/email/"+email,Patients.class);
    }

    public Boolean editPatientDetails(Patients patient, String currentContext) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Patients> entity = new HttpEntity<>(patient, httpHeaders);
        ResponseEntity<String> response = this.restTemplate.exchange(currentContext + url + "/update/" + patient.getP_id(), HttpMethod.PUT, entity, String.class);
        return response.getStatusCodeValue() == 204;
    }
    public void deletePatient(Integer id, String currentContext) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        restTemplate.delete(currentContext+url+"/delete/"+id);
    }
}
