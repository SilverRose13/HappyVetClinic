package edu.pjatk.s19701.model;

import jakarta.persistence.*;

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

    //@TODO setPlural like Diseases, doet not match to what this method do, as it accept only single object (not a list)

    public void setDiseases(Diseases disease) {
        this.disease = disease;
    }
}
