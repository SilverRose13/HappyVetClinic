package edu.pjatk.s19701.model.employee;

import edu.pjatk.s19701.model.JobTitle;
import edu.pjatk.s19701.model.person.Person;
import edu.pjatk.s19701.model.Clinic;
import jakarta.persistence.*;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "Employee")
@SuppressWarnings("unused")
public class Employee extends Person {
    static Logger logger = Logger.getLogger(Employee.class.getName());

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "job_title")
    private JobTitle jobTitle;
    @Override
    public void setName(String name) {
        logger.log(Level.INFO, () -> "Setting name for employee: {}"  + name);
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        logger.log(Level.INFO, () -> "Setting surname for employee: "  + surname);
        super.setSurname(surname);
    }

    @Override
    public void setUsername(String username) {
        logger.log(Level.INFO, () -> "Setting surname for employee: "  + username);
        super.setUsername(username);
    }

    public void setUsername() {
        super.setUsername(UUID.randomUUID().toString());
        logger.info("Setting username for employee: "  + super.getUsername());
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "clinic=" + clinic +
                ", jobTitle=" + jobTitle +
                '}';
    }
}
