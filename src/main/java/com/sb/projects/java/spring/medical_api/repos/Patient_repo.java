package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Patient_repo extends JpaRepository<Patients, Integer> {
    Optional<List<Patients>> findByName(String name);
    Optional<Patients> findByEmail(String email);
}
