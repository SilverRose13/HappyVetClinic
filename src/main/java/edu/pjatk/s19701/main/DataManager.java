package edu.pjatk.s19701.main;

import edu.pjatk.s19701.model.*;
import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.employee.Employee;
import edu.pjatk.s19701.model.owner.Owner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class managing data. Creating initial data-set in one-transaction using Hibernate ORM library.
 */
public class DataManager {

    static Logger logger = Logger.getLogger(DataManager.class.getName());

    public void initDataSet(){
        Clinic clinic = createClinic();
        Employee employee = createEmployee(clinic);

        Owner owner = createOwner();
        Pet pet = createPet();

        Visit visit = createVisit();
        Condition condition = createCondition();



        //createRelations(owner,condition, visit, pet, employee);
    }

    private void createRelations(Owner owner, Condition condition,
                                 Visit visit, Pet pet,
                                 Employee employee) {
        pet.setOwner(owner);
        pet.addVisit(visit);

        visit.addCondition(condition);
        visit.setPet(pet);
        visit.setEmployee(employee);

        condition.addVisit(visit);

        HibernateSessionFactory.save(owner);
        HibernateSessionFactory.save(condition);
        HibernateSessionFactory.save(visit);
        HibernateSessionFactory.save(pet);
        HibernateSessionFactory.save(employee);
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
        owner.setName("OwnerName");
        owner.setSurname("OwnerSurname");
        owner.setPassword("owner");
        owner.setUsername("Owner");

        HibernateSessionFactory.save(owner);
        return owner;
    }

    private static Pet createPet(){
        Pet pet = new Pet();

        pet.setChipNumber("9876543210");
        pet.setName("Zazu");
        pet.setBirthday(LocalDate.of(2020, 12, 12));

        HibernateSessionFactory.save(pet);
        return pet;
    }

    private Condition createCondition() {
        Condition condition = new Condition();
        condition.setDiseases(Disease.ANTHRAX);
        condition.setSymptoms("high fever, blood around nose and mouth");

        HibernateSessionFactory.save(condition);
        return condition;
    }

    private Visit createVisit() {
        Visit visit = new Visit();
        Condition condition = new Condition();
        condition.setDiseases(Disease.OTHER);
        condition.setSymptoms("Looks bad");
        visit.addCondition(condition);
        visit.setDateTime(LocalDateTime.now().minusMonths(1));

        HibernateSessionFactory.save(visit);
        return visit;
    }


}
