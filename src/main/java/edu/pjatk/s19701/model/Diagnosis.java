package edu.pjatk.s19701.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false)
    @Id
    private UUID diagnosisId;

}
