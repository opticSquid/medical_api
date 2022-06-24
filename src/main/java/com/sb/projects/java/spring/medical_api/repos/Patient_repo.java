package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import org.springframework.data.repository.CrudRepository;

public interface Patient_repo extends CrudRepository<Patients, Integer> {
}
