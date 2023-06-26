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
        createEmployee(clinic);
        createOwner();
        createPet();
        createVisit();
        createCondition();
    }

    private Clinic createClinic() {
        Clinic clinic = new Clinic();
        clinic.setAddress("Address");

        HibernateSessionFactory.save(clinic);

        return clinic;
    }

    private void createEmployee(Clinic clinic) {
        Employee employee = new Employee();
        employee.setName("EmployeeName");
        employee.setSurname("EmployeeSurname");
        employee.setPassword("admin");
        employee.setUsername("Vet");
        employee.setJobTitle(JobTitle.VETERINARIAN);
        employee.setClinic(clinic);

        HibernateSessionFactory.save(employee);
    }

    private static void createOwner() {
        Owner owner = new Owner();
        owner.setName("Ownername");
        owner.setSurname("OwnerSurname");
        owner.setPassword("owner");
        owner.setUsername("Owner");

        HibernateSessionFactory.save(owner);
    }

    private static void createPet(){
        Pet pet = new Pet();

        pet.setChipNumber("9876543210");
        pet.setName("Zazu");
        pet.setBirthday(LocalDate.of(2020, 12, 12));

        HibernateSessionFactory.save(pet);
    }

    private void createCondition() {
        Condition condition = new Condition();
        condition.setDiseases(Disease.ANTHRAX);
        condition.setSymptoms("high fever, blood around nose and mouth");

        HibernateSessionFactory.save(condition);
    }

    private void createVisit() {
        Visit visit = new Visit();
        Condition condition = new Condition();
        condition.setDiseases(Disease.OTHER);
        condition.setSymptoms("Looks bad");
        visit.setDateTime(LocalDateTime.now().minusMonths(1));

        HibernateSessionFactory.save(visit);
    }


}
