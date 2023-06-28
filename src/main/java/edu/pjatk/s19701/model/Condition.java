package edu.pjatk.s19701.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Condition")
public class Condition {

    @Id
    @GeneratedValue
    @Column(updatable = false )
    private UUID id;
    @Column(name = "symptoms", nullable = false)
    private String symptoms;

    @Column
    private List<Disease> diseases = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "conditions")
    private Set<Visit> visits = new HashSet<>();

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

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", symptoms='" + symptoms + '\'' +
                ", diseases=" + diseases +
                ", visits=" + visits +
                '}';
    }
}
