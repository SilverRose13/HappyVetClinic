package edu.pjatk.s19701.model.owner;

import edu.pjatk.s19701.main.HibernateSessionFactory;
import edu.pjatk.s19701.model.person.Person;
import edu.pjatk.s19701.model.person.PersonDaoInterface;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
//Data Access Object
//Used to retrieve data saved in the Owner entity
public class OwnerDao implements OwnerDaoInterface, PersonDaoInterface<Person, String> {


    private static Session getOrOpenSession() {
        return HibernateSessionFactory.getOrOpenSession();
    }

    /**
     * @param username
     * @param password
     * @return
     */

    //verifies if an Owner with the provided credentials exists
    @Override
    public boolean verifyIfLoginAndPassExists(String username, String password) {
        Owner owner = new Owner();
        owner.setUsername(username);
        owner.setPassword(password);


        Transaction transaction = getOrOpenSession().beginTransaction();

        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);

        Root<Owner> from = criteriaQuery.from(Owner.class);

        List<Predicate> predicates = new ArrayList<>();
        //for login there are "multiple criteria" as both the username and password need to match the provided
        predicates.add(criteriaBuilder.equal(from.get("username"), username));
        predicates.add(criteriaBuilder.equal(from.get("password"), password));

        //setting up the query
        criteriaQuery.select(from).where(predicates.toArray(new Predicate[]{}));

        Query<Owner> query = getOrOpenSession().createQuery(criteriaQuery);
        //should only be one since the username must be unique
        query.setMaxResults(1);
        boolean isNotEmpty = !query.getResultList().isEmpty();
        transaction.commit();

        return isNotEmpty;
    }

    @Override
    public Owner verifyOwnerExistence(String name, String surname) {
        Owner owner = new Owner();
        owner.setName(name);
        owner.setSurname(surname);

        Transaction transaction = getOrOpenSession().beginTransaction();

        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = criteriaBuilder.createQuery(Owner.class);

        Root<Owner> from = criteriaQuery.from(Owner.class);

        List<Predicate> predicates = new ArrayList<>();
        //for login there are "multiple criteria" as both the username and password need to match the provided
        predicates.add(criteriaBuilder.equal(from.get("name"), name));
        predicates.add(criteriaBuilder.equal(from.get("surname"), surname));

        //setting up the query
        criteriaQuery.select(from).where(predicates.toArray(new Predicate[]{}));

        Query<Owner> query = getOrOpenSession().createQuery(criteriaQuery);
        //should only be one since the username must be unique
        query.setMaxResults(1);
        List<Owner> result = query.getResultList();
        transaction.commit();

        if(result.isEmpty()){
            return null;
        } else {
            return result.get(0);
        }
    }
}
