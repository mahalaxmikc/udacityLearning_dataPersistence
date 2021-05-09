package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerServiceImpl customerService;

    public Pet savePet(Pet pet,Long ownerID){
     /*   Customer customer= customerService.retrieveCustomerByID(ownerID);
        customer.addPet(pet);
        customerService.saveCustomer(customer);

        pet.setCustomer(customer);
        Pet storedPet= petRepository.save(pet);
        return storedPet;*/

        Customer customer;
        customer = customerService.retrieveCustomerByID(ownerID);
        pet.setCustomer(customer);
        Pet storedPet = petRepository.save(pet);

        customer = storedPet.getCustomer();
        customer.addPet(storedPet);
        customerService.saveCustomer(customer);
        return storedPet;
    }

    @Override
    public Pet retrievePetByID(Long petID) {
        return petRepository.getOne(petID);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getPetsByOwnerId(Long ownerId) {
        /*
         .filter(pet -> pet.getCustomer().getId() == ownerId)
                .map(this::getDTO)
                .collect(Collectors.toList());
         */
        return petRepository.findAll().stream().
                filter(pet -> pet.getCustomer().getId()==ownerId).collect(Collectors.toList());

    }
}
