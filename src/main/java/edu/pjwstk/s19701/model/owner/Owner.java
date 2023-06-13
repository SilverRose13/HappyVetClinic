package edu.pjwstk.s19701.model.owner;

import edu.pjwstk.s19701.model.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Owner")
@SuppressWarnings("unused")
public class Owner extends Person {
    @Override
    public void setName(String name) {
        System.out.println("Setting name for pet owner: "  + name);
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        System.out.println("Setting surname for pet owner: "  + surname);
        super.setSurname(surname);
    }

    @Override
    public void setUsername(String username) {
        System.out.println("Setting username for pet owner: "  + username);
        super.setUsername(username);
    }
}
