package edu.pjwstk.s19701.model.pet;

import edu.pjwstk.s19701.model.Visit;
import edu.pjwstk.s19701.model.owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "chipNumber")
    private String chipNumber;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany
    @JoinColumn(name = "visit_id")
    private Set<Visit> visits;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
