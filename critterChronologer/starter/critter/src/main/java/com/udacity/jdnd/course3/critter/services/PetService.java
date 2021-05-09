package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Pet;

import java.util.List;

public interface PetService {

    public Pet savePet(Pet pet, Long customerID);
    public Pet retrievePetByID(Long petID);
    public List<Pet> getAllPets();
    public  List<Pet> getPetsByOwnerId(Long ownerId);

}
