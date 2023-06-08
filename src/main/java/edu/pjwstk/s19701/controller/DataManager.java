package edu.pjwstk.s19701.controller;

import edu.pjwstk.s19701.model.Clinic;
import edu.pjwstk.s19701.model.Employee;
import edu.pjwstk.s19701.model.JobTitle;
import edu.pjwstk.s19701.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public static void save(Object o){
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save
            session.persist(o);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void readEmployee() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Person> person = session.createQuery("from Employee ", Person.class).list();
            person.forEach(s -> logger.info("System user ID: " + s.getName() + " id: " + s.getPersonId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
