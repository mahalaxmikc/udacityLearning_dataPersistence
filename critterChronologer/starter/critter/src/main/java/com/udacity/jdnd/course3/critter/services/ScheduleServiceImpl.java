package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Schedule createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule= new Schedule();
        schedule.setEmployeeList(employeeRepository
                .findAll()
                .stream()
                .filter(employee -> scheduleDTO.getEmployeeIds().contains(employee.getId()))
                .collect(Collectors.toList()));
        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setId(scheduleDTO.getId());
        schedule.setPetList(petRepository.findAll()
                .stream()
                .filter(pet -> scheduleDTO.getPetIds().contains(pet.getId()))
                .collect(Collectors.toList()));
        schedule.setDate(scheduleDTO.getDate());

           return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getSchedulesForPetId(long petId) {
        /*Pet pet = petRepository.getOne(petId); // mark while submitting the project
        return scheduleRepository.getSchedulesByPetsContains(pet);*/
        Pet pet = petRepository.getOne(petId);
        return scheduleRepository.findAll().stream().
                filter(schedule -> schedule.getPetList().contains(pet))
                .collect(Collectors.toList());

    }

    @Override
    public List<Schedule> getSchedulesForEmployee(long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);

        return scheduleRepository.findAll().stream().
                filter(schedule -> schedule.getEmployeeList().contains(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> getSchedulesForCustomer(long customerId) {
        Customer customer= customerRepository.getOne(customerId);
        return scheduleRepository.findAll().stream().
                filter(schedule -> schedule.getPetList().containsAll(customer.getPetList())).
                collect(Collectors.toList());
    }
}
