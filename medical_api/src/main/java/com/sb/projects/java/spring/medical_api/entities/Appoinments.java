package com.sb.projects.java.spring.medical_api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appoinments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int apmnt_id;
    @ManyToOne
    @JoinColumn(name = "doctor_d_id")
    private Doctors doctor;
    @ManyToOne
    @JoinColumn(name = "patients_p_id")
    private Patients patients;

    private LocalDateTime time;

    public int getApmnt_id() {
        return apmnt_id;
    }

    public void setApmnt_id(int apmnt_id) {
        this.apmnt_id = apmnt_id;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalDateTime.now();
    }
}
