package edu.pjatk.s19701.model;

import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "Visit")
public class Visit {

    @Id
    @GeneratedValue
    @Column(updatable = false )
    private UUID id;

    //relation to the Employee supervising the Visit
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "dateTime", nullable = false)
    private LocalDateTime dateTime;

    //relation to the Pet being treated at the visit
    @ManyToOne(cascade = CascadeType.ALL, optional=false)
    @JoinColumn(name="pet_id", nullable=false, updatable=false)
    private Pet pet;

    //relation to the conditions observed and/or diagnosed during the visit
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name="VISIT_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "CONDITION_ID", referencedColumnName = "id")
    )
    public Set<Condition> conditions = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
    }


    //primarily for printing of conditions for the Medical Conditions section in the PetRecord screen
    private String prettyPrintConditions() {
        StringBuilder sb = new StringBuilder();
        this.conditions.forEach(c -> {
            sb.append("Symptom: ").append(c.getSymptoms()).append("\n");

            c.getDiseases().forEach(d -> sb.append("Disease diagnosed: ").append(d.name()).append("\n"));
        });

        return sb.toString();
    }
    @Override
    public String toString() {
        return "Visit: " + dateTime.toLocalDate()  + "\n Supervised by "
                + getEmployee().getFullName() + "\n"
                + prettyPrintConditions();
    }
}
