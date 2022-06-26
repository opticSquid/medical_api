package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patient_repo extends JpaRepository<Patients, Integer> {
}
