package edu.pjwstk.s19701.controller;

import edu.pjwstk.s19701.model.pet.Pet;
import edu.pjwstk.s19701.model.pet.PetDao;
import edu.pjwstk.s19701.model.pet.PetDaoInterface;

public class SearchByChipCotroller {

    PetDao petDao = new PetDao();

    public Pet findPetByChip(String chipNumber){
        return petDao.searchByChip(chipNumber);
    }
}
