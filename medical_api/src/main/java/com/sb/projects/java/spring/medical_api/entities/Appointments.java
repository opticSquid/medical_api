package com.sb.projects.java.spring.medical_api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int apmnt_id;
    @ManyToOne
    @JoinColumn(name = "doctor_d_id")
    private Doctors doctor;
    @ManyToOne
    @JoinColumn(name = "patient_p_id")
    private Patients patient;
    private LocalDateTime time;
    private String ailment;
    @ElementCollection
    @CollectionTable(name = "prescriptions", joinColumns = @JoinColumn(name = "apmnt_id"))
    private List<String> prescription;

    public int getApmnt_id() {
        return apmnt_id;
    }

    public void setApmnt_id(int apmnt_id) {
        this.apmnt_id = apmnt_id;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
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

    public void setTime(LocalDateTime time) {

        this.time = time == null ? LocalDateTime.now() : time;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String problem) {
        this.ailment = problem;
    }

    public List<String> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<String> prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "apmnt_id=" + apmnt_id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", time=" + time +
                ", ailment='" + ailment + '\'' +
                ", prescription=" + prescription +
                '}';
    }
}
