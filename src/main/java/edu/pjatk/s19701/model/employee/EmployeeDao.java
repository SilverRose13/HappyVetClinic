package edu.pjatk.s19701.model.employee;

import edu.pjatk.s19701.model.person.PersonDaoInterface;
import edu.pjatk.s19701.main.HibernateSessionFactory;
import edu.pjatk.s19701.model.person.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements PersonDaoInterface<Person, String> {

    private static Session getOrOpenSession() {
        return HibernateSessionFactory.getOrOpenSession();
    }

    /**
     * @param username - username
     * @param password - password
     * @return if db contains user with given password.
     */
    @Override
    public boolean verifyIfLoginAndPassExists(String username, String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);

        Transaction transaction = getOrOpenSession().beginTransaction();
        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(from.get("username"), username));
        predicates.add(criteriaBuilder.equal(from.get("password"), password));

        criteriaQuery.select(from).where(predicates.toArray(new Predicate[]{}));

        Query<Employee> query = getOrOpenSession().createQuery(criteriaQuery);
        query.setMaxResults(1);

        boolean isNotEmpty = !query.getResultList().isEmpty();
        transaction.commit();

        return isNotEmpty;
    }
}
