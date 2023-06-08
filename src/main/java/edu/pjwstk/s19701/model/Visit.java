package edu.pjwstk.s19701.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "Visit")
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



    //conditions
    @ManyToMany(targetEntity = Visit.class, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Diagnosis",
            joinColumns = @JoinColumn(name = "id_visit"),
            inverseJoinColumns = @JoinColumn(name = "id_condition")
    )
    private ArrayList<Condition> conditions;

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }
}