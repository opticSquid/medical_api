package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Appointment_repo extends JpaRepository<Appointments, Integer> {
}
