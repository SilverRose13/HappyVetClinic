package edu.pjwstk.s19701.model;

import edu.pjwstk.s19701.model.owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "birthday")
    private LocalDateTime birthday;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }


}
