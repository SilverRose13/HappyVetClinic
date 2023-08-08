package edu.pjatk.s19701.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

}
