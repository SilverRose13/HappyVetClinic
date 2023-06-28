package edu.pjatk.s19701.main;

import edu.pjatk.s19701.model.*;
import edu.pjatk.s19701.model.employee.Employee;
import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.pet.Pet;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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
        Visit visit = createVisit(pet, employee);
        logger.log(Level.INFO, "Registered visit: {0}", visit);
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

    private Condition createCondition() {
        Condition condition = new Condition();
        condition.setDiseases(List.of(Disease.ANTHRAX));
        condition.setSymptoms("high fever, blood around nose and mouth");

        HibernateSessionFactory.save(condition);
        return condition;
    }

    private Visit createVisit(Pet pet, Employee employee) {
        Visit visit = new Visit();
        visit.setDateTime(LocalDateTime.now().minusMonths(1));
        visit.setPet(pet);
        visit.setEmployee(employee);

        Condition sampleCondition = new Condition();
        sampleCondition.setSymptoms("tmp");
        sampleCondition.setDiseases(List.of(Disease.AFLATOXICOSIS));
        visit.setConditions(Set.of(sampleCondition));
        pet.getVisits().add(visit);
        HibernateSessionFactory.save(visit);


        //walk around - below object should be somehow updated by save visits, but it is not.
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(pet);
            session.getTransaction().commit();
        } catch(Exception e) {
            logger.warning("Not successfully PET merge");
        }

        return visit;
    }


}
