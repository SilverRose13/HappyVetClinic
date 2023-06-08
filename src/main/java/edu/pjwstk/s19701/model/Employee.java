package edu.pjwstk.s19701.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends Person {
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "job_title")
    private JobTitle jobTitle;
    @Override
    public void setName(String name) {
        System.out.println("Setting name for employee: "  + name);
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        System.out.println("Setting surname for employee: "  + surname);
        super.setSurname(surname);
    }

    @Override
    public void setUsername(String username) {
        System.out.println("Setting username for employee: "  + username);
        super.setUsername(username);
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }
}
