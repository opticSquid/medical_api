package com.sb.projects.java.spring.medical_api.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Patients {
    @Id
    @NotNull
    private int p_id;
    private String name;
    private String email;
    private String contact_no;
    @OneToOne
    private Doctors doctor;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
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

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }


}
