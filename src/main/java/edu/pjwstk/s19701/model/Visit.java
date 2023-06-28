package edu.pjwstk.s19701.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Visit {
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

    @Column(name = "pet", nullable = false)
    private String pet;
    public String getPet(){return pet;}
    public void setId_pet(String pet) {
        this.pet = pet;
    }

    @Column(name = "employee", nullable = false)
    private String employee;
    public String getEmployee(){return employee;}
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Column(name = "dateTime", nullable = false)
    private LocalDateTime dateTime;
    public LocalDateTime getDateTime(){return dateTime;}
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
