package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dtos.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface EmployeeService  {

    public Employee saveEmployee(EmployeeDTO employeeDTO);
    public  void  updateEmployeeAvailability(Set<DayOfWeek> daysAvailable,Long employeeID);
    public Employee retrieveEmployeeByID(Long employeeID);
    public List<Employee> retrieveEmployeeService(EmployeeRequestDTO employeeDTO);
    public List<Employee> getAll();
}
