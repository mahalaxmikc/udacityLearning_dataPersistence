package com.udacity.jdnd.course3.critter.entities;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer  extends  User{

    @Nationalized
    private String phoneNumber;

    @Nationalized
    private String notes;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pet> petList = new ArrayList<Pet>();

    public Customer() {
    }

    public Customer(Long id,String name, String phoneNumber, String notes, List<Pet> petList) {
        super(id, name);
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.petList = petList;
    }


    //helper method
    public void addPet(Pet pet){
        this.petList.add(pet);
        pet.setCustomer(this);

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", notes='" + notes + '\'' +
                ", petList=" + petList +
                '}';
    }
}
