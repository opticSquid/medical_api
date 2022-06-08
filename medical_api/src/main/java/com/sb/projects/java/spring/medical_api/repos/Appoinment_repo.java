package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Appoinments;
import org.springframework.data.repository.CrudRepository;

public interface Appoinment_repo extends CrudRepository<Appoinments, Integer> {
}
