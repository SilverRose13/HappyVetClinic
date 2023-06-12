package edu.pjwstk.s19701.model.pet;

import edu.pjwstk.s19701.controller.HibernateSessionFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PetDao implements PetDaoInterface{

    private static Session getOrOpenSession(){return HibernateSessionFactory.getOrOpenSession();}

    @Override
    public Pet searchByChip(String chipNumber){

        Transaction transaction = getOrOpenSession().beginTransaction();
        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();

        CriteriaQuery<Pet> criteriaQuery = criteriaBuilder.createQuery(Pet.class);
        Root<Pet> from = criteriaQuery.from(Pet.class);

        criteriaQuery.select(from).where(criteriaBuilder.like(from.get("chipNumber"), chipNumber));

        Query<Pet> query = getOrOpenSession().createQuery(criteriaQuery);
        query.setMaxResults(1);
        List<Pet> result = query.getResultList();

        transaction.commit();

        if(result.toArray().length == 0) {
            return null;
        } else {
            return result.get(0);
        }


    }

}
