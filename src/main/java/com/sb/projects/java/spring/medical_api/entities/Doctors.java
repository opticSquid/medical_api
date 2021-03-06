package com.sb.projects.java.spring.medical_api.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int d_id;
    @Size(min=6,message = "Name should be at least 6 characters long")
    private String name;
    private String email;
    @NotBlank
    private String degree;
    @NotBlank
    private String specialization;


    public int getD_id() {
        return d_id;
    }

    public void setD_id(int doc_id) {
        this.d_id = doc_id;
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


    @Override
    public String toString() {
        return "Doctors{" +
                "d_id=" + d_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
