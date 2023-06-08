package edu.pjwstk.s19701.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private Diseases diseases;
    @Column(name = "symptoms", nullable = false)
    private String symptoms;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getSymptoms(){return symptoms;}
    public void setSymptoms(String name) {
        this.symptoms = symptoms;
    }


}
