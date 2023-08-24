package edu.pjatk.s19701.model.pet;

import edu.pjatk.s19701.main.HibernateSessionFactory;
import edu.pjatk.s19701.model.owner.Owner;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

//provides communication between the application layer and the database
public class PetDao implements PetDaoInterface{

    //ensures a session is established so that the class can communicate with the DB
    private static Session getOrOpenSession(){return HibernateSessionFactory.getOrOpenSession();}

    //verifies if a Pet with the provided chip number exists
    //passes the record on if it does
    @Override
    public Pet searchByChip(String chipNumber){

        Transaction transaction = getOrOpenSession().beginTransaction();
        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();


        CriteriaQuery<Pet> criteriaQuery = criteriaBuilder.createQuery(Pet.class);
        Root<Pet> from = criteriaQuery.from(Pet.class);

        //specifying the criteria for the query
        //searching for a Pet record with a chip number like the one provided
        criteriaQuery.select(from).where(criteriaBuilder.like(from.get("chipNumber"), chipNumber));

        //specifying the entity being queried and the query criteria
        Query<Pet> query = getOrOpenSession().createQuery(criteriaQuery);
        //there should only be one anyway as chipNumber is a unique field
        query.setMaxResults(1);
        //lists the results of the query
        List<Pet> result = query.getResultList();

        //ends the transaction
        transaction.commit();

        //returning the results of the query
        if(result.toArray().length == 0) {
            return null;
        } else {
            return result.get(0);
        }


    }

    //compiles a list of Pets associated with the provided Owner
    public List<Pet> getOwnersPets(Owner owner) {
        Transaction transaction = getOrOpenSession().beginTransaction();
        CriteriaBuilder criteriaBuilder = getOrOpenSession().getCriteriaBuilder();


        CriteriaQuery<Pet> criteriaQuery = criteriaBuilder.createQuery(Pet.class);
        Root<Pet> from = criteriaQuery.from(Pet.class);

        //specifying the criteria for the query
        //searching for a Pet record with the specified Owner like the one provided
        criteriaQuery.select(from).where(criteriaBuilder.equal(from.get("owner"), owner));

        //specifying the entity being queried and the query criteria
        Query<Pet> query = getOrOpenSession().createQuery(criteriaQuery);

        //lists the results of the query
        List<Pet> result = query.getResultList();

        //ends the transaction
        transaction.commit();

        //returning the results of the query
        if(result.toArray().length == 0) {
            return null;
        } else {
            return result;
        }

    }
}
