package edu.pjwstk.s19701.controller;

import edu.pjwstk.s19701.model.Employee;
import edu.pjwstk.s19701.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DataManager {

    public void initDataSet(){
        createEmployee();
    }


    private static void createEmployee() {
        Person employee = new Employee();
        employee.setName("Alfa");

        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save
            session.persist(employee);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Person> person = session.createQuery("from Employee ", Person.class).list();
            person.forEach(s -> System.out.println("System user ID: " + s.getName() + " id: " + s.getPersonId()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
