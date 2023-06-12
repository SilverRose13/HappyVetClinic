package edu.pjwstk.s19701.controller;

import edu.pjwstk.s19701.model.Clinic;
import edu.pjwstk.s19701.model.employee.Employee;
import edu.pjwstk.s19701.model.JobTitle;
import edu.pjwstk.s19701.model.owner.Owner;
import edu.pjwstk.s19701.model.pet.Pet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    }

    private Clinic createClinic() {
        Clinic clinic = new Clinic();
        clinic.setAddress("Address");
        save(clinic);

        return clinic;
    }

    private static void createEmployee(Clinic clinic) {
        Employee employee = new Employee();
        employee.setName("EmployeeName");
        employee.setSurname("EmployeeSurname");
        employee.setPassword("admin");
        employee.setUsername("Vet");
        employee.setJobTitle(JobTitle.VETERINARIAN);
        employee.setClinic(clinic);

        save(employee);
    }

    private static void createOwner() {
        Owner owner = new Owner();
        owner.setName("Ownername");
        owner.setSurname("OwnerSurname");
        owner.setPassword("owner");
        owner.setUsername("Owner");

        save(owner);
    }

    private static void createPet(){
        Pet pet = new Pet();

        pet.setChipNumber("9876543210");
        pet.setName("Zazu");
        pet.setBirthday(LocalDate.of(2020, 12, 12));

        save(pet);
    }

    public static void save(Object o){
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save
            session.persist(o);

            // commit transaction
            transaction.commit();
        } catch (HibernateException he) {
            System.err.println(he.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
