package edu.pjwstk.s19701.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends Person {
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Override
    public void setName(String name) {
        System.out.println("Setting name for employee: "  + name);
        super.setName(name);
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }


}
