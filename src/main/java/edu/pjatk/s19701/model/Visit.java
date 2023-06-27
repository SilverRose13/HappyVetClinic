package edu.pjatk.s19701.model;

import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Visit")
public class Visit {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "dateTime", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @ManyToMany(mappedBy = "diagnosis")
    private Set<Condition> conditions = new HashSet<>();


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

    public void addCondition(Condition condition){
        conditions.add(condition);
    }
}
