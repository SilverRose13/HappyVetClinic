package edu.pjatk.s19701.model.pet;

import edu.pjatk.s19701.model.Visit;
import edu.pjatk.s19701.model.owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Pet")
@SuppressWarnings("unused")
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

    @Column(name = "breed")
    private String breed;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Set<Visit> visits = new HashSet<>();

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    //method for getting the age of a Pet from their birthday
    public int getAge(){

        LocalDate currentDate = LocalDate.now();

        if(Period.between(birthday, currentDate).getYears() > 0){
            return Period.between(birthday, currentDate).getYears();
        } else {
            return Period.between(birthday, currentDate).getMonths();
        }

    }

    public void addVisits(Visit visit) {
        visits.add(visit);
    }
}
