package edu.pjwstk.s19701.model.owner;

import edu.pjwstk.s19701.controller.HibernateSessionFactory;
import edu.pjwstk.s19701.model.person.Person;
import edu.pjwstk.s19701.model.person.PersonDaoInterface;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OwnerDao implements OwnerDaoInterface, PersonDaoInterface<Person, String> {

    private static Session getOrOpenSession() {
        return HibernateSessionFactory.getOrOpenSession();
    }

    /**
     * @param username
     * @param password
     * @return
     */
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
        predicates.add(criteriaBuilder.equal(from.get("username"), username));
        predicates.add(criteriaBuilder.equal(from.get("password"), password));

        criteriaQuery.select(from).where(predicates.toArray(new Predicate[]{}));

        Query<Owner> query = getOrOpenSession().createQuery(criteriaQuery);
        query.setMaxResults(1);
        boolean isNotEmpty = !query.getResultList().isEmpty();
        transaction.commit();

        return isNotEmpty;
    }
}
