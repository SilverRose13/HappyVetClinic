package edu.pjatk.s19701.controller;

import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.pet.PetDao;

public class SearchByChipController {

    PetDao petDao = new PetDao();

    //searching for a record of a Pet with the provided chip number
    //Uses  DAO  class to communicate with the database
    public Pet findPetByChip(String chipNumber){
        return petDao.searchByChip(chipNumber);
    }
}
