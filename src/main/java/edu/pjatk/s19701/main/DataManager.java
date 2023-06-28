package edu.pjatk.s19701.main;

import edu.pjatk.s19701.model.*;
import edu.pjatk.s19701.model.employee.Employee;
import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.pet.Pet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class managing data. Creating initial data-set in one-transaction using Hibernate ORM library.
 */
public class DataManager {

    static Logger logger = Logger.getLogger(DataManager.class.getName());

    public void initDataSet() {
        Clinic clinic = createClinic();
        Owner owner = createOwner();
        Pet pet = createPet(owner);
        createCondition();
        Employee employee = createEmployee(clinic);
        Visit visit = createVisit(pet, employee, 1, Disease.AFLATOXICOSIS);
        logger.log(Level.INFO, "Registered visit: {0}", visit);

        Visit earlierVisit = createVisit(pet, employee, 2, Disease.ANTHRAX);
        logger.log(Level.INFO, "Registered visit: {0}", earlierVisit);
    }

    private Clinic createClinic() {
        Clinic clinic = new Clinic();
        clinic.setAddress("Address");

        HibernateSessionFactory.save(clinic);
        return clinic;
    }

    private Employee createEmployee(Clinic clinic) {
        Employee employee = new Employee();
        employee.setName("EmployeeName");
        employee.setSurname("EmployeeSurname");
        employee.setPassword("admin");
        employee.setUsername("Vet");
        employee.setJobTitle(JobTitle.VETERINARIAN);
        employee.setClinic(clinic);

        HibernateSessionFactory.save(employee);
        return employee;
    }

    private static Owner createOwner() {
        Owner owner = new Owner();
        owner.setName("Marek");
        owner.setSurname("Banasik");
        owner.setPassword("owner");
        owner.setUsername("Owner");

        HibernateSessionFactory.save(owner);
        return owner;
    }

    private static Pet createPet(Owner owner) {
        Pet pet = new Pet();
        pet.setChipNumber("9876543210");
        pet.setName("Zazu");
        pet.setBirthday(LocalDate.of(2020, 12, 12));
        pet.setOwner(owner);
        pet.setBreed("Siberian Husky");
        HibernateSessionFactory.save(pet);
        return pet;
    }

    private void createCondition() {
        Condition condition = new Condition();
        condition.setDiseases(List.of(Disease.ANTHRAX));
        condition.setSymptoms("high fever, blood around nose and mouth");

        HibernateSessionFactory.save(condition);
    }

    private Visit createVisit(Pet pet, Employee employee, int monthsAgo, Disease disease) {
        Visit visit = new Visit();
        visit.setDateTime(LocalDateTime.now().minusMonths(monthsAgo));
        visit.setPet(pet);
        visit.setEmployee(employee);

        Condition sampleCondition = new Condition();
        sampleCondition.setSymptoms("Sample symptom");
        sampleCondition.setDiseases(List.of(disease));
        sampleCondition.getVisits().add(visit);
        visit.getConditions().add(sampleCondition);

        pet.getVisits().add(visit);
        HibernateSessionFactory.save(visit);

        return visit;
    }


}
