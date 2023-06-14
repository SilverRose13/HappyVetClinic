package edu.pjwstk.s19701.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Condition")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "symptoms", nullable = false)
    private String symptoms;
    @Column
    private Diseases disease;

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

    public Diseases getDiseases() {
        return disease;
    }

    public void setDiseases(Diseases disease) {
        this.disease = disease;
    }
}
