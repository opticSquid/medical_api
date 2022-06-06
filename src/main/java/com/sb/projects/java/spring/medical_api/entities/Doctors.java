package com.sb.projects.java.spring.medical_api.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Doctors {
    @Id
    @NotNull
    private int doc_id;
    private String name;
    private String email;
    private String degree;
    private String specialization;
    @OneToMany
    private List<Patients> patients;

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }
}
