package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;

import java.util.List;

public interface CustomerService {

     public Customer saveCustomer(Customer customer);
     public Customer retrieveCustomerByID(Long CustomerID);
     public List<Customer> getAll();
     public Customer getCustomerByPetId(long PetId);

}
