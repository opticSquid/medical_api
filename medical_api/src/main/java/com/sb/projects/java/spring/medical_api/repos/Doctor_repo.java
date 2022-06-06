package com.sb.projects.java.spring.medical_api.repos;

import com.sb.projects.java.spring.medical_api.entities.Doctors;
import org.springframework.data.repository.CrudRepository;

public interface Doctor_repo extends CrudRepository<Doctors,Integer> {
}
