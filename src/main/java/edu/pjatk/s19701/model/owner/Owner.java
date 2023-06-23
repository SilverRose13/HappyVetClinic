package edu.pjatk.s19701.model.owner;

import edu.pjatk.s19701.model.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "Owner")
@SuppressWarnings("unused")
public class Owner extends Person {
    static Logger logger = Logger.getLogger(Owner.class.getName());

    @Override
    public void setName(String name) {
        logger.log(Level.INFO, () -> "Setting name for pet owner: {}"  + name);
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        logger.log(Level.INFO, () -> "Setting surname for pet owner:  {}"  + surname);
        super.setSurname(surname);
    }

    @Override
    public void setUsername(String username) {
        logger.log(Level.INFO, () -> "Setting username for pet owner: {}"  + username);
        super.setUsername(username);
    }
}
