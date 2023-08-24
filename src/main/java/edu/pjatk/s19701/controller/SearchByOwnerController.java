package edu.pjatk.s19701.controller;

import edu.pjatk.s19701.model.owner.Owner;
import edu.pjatk.s19701.model.owner.OwnerDao;
import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.pet.PetDao;

import java.util.List;

public class SearchByOwnerController {

    OwnerDao ownerDao = new OwnerDao();
    PetDao petDao = new PetDao();

    //searching for a record of a Pet with the provided Owner name and surname combination
    //Uses OwnerDao to communicate with database
    public Owner verifyOwnerExistence(String name, String surname){
        return ownerDao.verifyOwnerExistence(name, surname);
    }

    //returns a list of Pets associated with the provided Owner
    //Uses PetDao to communicate with the database
    public List<Pet> getOwnersPets(Owner owner){
        return petDao.getOwnersPets(owner);
    }

}
