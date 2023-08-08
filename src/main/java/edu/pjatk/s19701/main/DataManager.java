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
        Owner ownerWithPets = createOwner("Marek", "Banasik", "owner", "Owner");
        logger.log(Level.INFO, "Registered visit: {0}", ownerWithPets);
        Owner ownerSansPets = createOwner("Filipek", "Furman", "owner", "OtherOwner");
        logger.log(Level.INFO, "Registered visit: {0}", ownerSansPets);

        Pet Zazu = createPet("9876543210", "Zazu", LocalDate.of(2020, 12, 12), ownerWithPets, "Siberian Husky Mix");
        Pet Manu = createPet("0987654321", "Manu", LocalDate.of(2021, 12, 06), ownerWithPets, "Siberian Husky");
        createCondition();
        Employee employee = createEmployee(clinic);
        Visit visit = createVisit(Zazu, employee, 1, Disease.AFLATOXICOSIS);
        logger.log(Level.INFO, "Registered visit: {0}", visit);

        Visit earlierVisit = createVisit(Zazu, employee, 2, Disease.ANTHRAX);
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
        //setting the Employee's Clinic
        employee.setClinic(clinic);

        HibernateSessionFactory.save(employee);
        return employee;
    }

    private static Owner createOwner(String name, String surname, String password, String username) {
        Owner owner = new Owner();
        owner.setName(name);
        owner.setSurname(surname);
        owner.setPassword(password);
        owner.setUsername(username);

        HibernateSessionFactory.save(owner);
        return owner;
    }

    private static Pet createPet(String chipNumber, String name, LocalDate date, Owner owner, String breed) {
        Pet pet = new Pet();
        pet.setChipNumber(chipNumber);
        pet.setName(name);
        pet.setBirthday(date);
        pet.setOwner(owner);
        pet.setBreed(breed);
        HibernateSessionFactory.save(pet);
        return pet;
    }

    private void createCondition() {
        Condition condition = new Condition();
        condition.setDiseases(List.of(Disease.ANTHRAX));
        condition.setSymptoms("high fever, blood around nose and mouth");

        HibernateSessionFactory.save(condition);
        //saved to database but with no connection to a visit
    }

    private Visit createVisit(Pet pet, Employee employee, int monthsAgo, Disease disease) {
        Visit visit = new Visit();
        visit.setDateTime(LocalDateTime.now().minusMonths(monthsAgo));
        visit.setPet(pet);
        visit.setEmployee(employee);

        //setting the Condition observed during the Visit
        Condition sampleCondition = new Condition();
        sampleCondition.setSymptoms("Sample symptom");
        sampleCondition.setDiseases(List.of(disease));
        sampleCondition.getVisits().add(visit);
        //connecting the newly created condition with the visit being created
        visit.getConditions().add(sampleCondition);

        //setting which Pet was at this Visit
        pet.getVisits().add(visit);
        HibernateSessionFactory.save(visit);

        return visit;
    }


}
