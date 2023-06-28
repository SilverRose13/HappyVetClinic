package edu.pjatk.s19701.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Condition")
public class Condition {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;
    @Column(name = "symptoms", nullable = false)
    private String symptoms;
    @Column
    private ArrayList<Disease> diseases = new ArrayList<>();

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getSymptoms(){return symptoms;}
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Disease diseases) {
        this.diseases.add(diseases);
    }


    public void addVisit(Visit visit) {

    }
}
