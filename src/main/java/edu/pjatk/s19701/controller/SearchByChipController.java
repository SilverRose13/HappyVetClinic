package edu.pjatk.s19701.controller;

import edu.pjatk.s19701.model.pet.Pet;
import edu.pjatk.s19701.model.pet.PetDao;

public class SearchByChipController {

    PetDao petDao = new PetDao();

    public Pet findPetByChip(String chipNumber){
        return petDao.searchByChip(chipNumber);
    }
}
