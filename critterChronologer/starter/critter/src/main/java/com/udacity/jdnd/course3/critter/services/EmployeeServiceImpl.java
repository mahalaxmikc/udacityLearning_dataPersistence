package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dtos.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl  implements
        EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {

            Employee employee = new Employee();

            employee.setId(employeeDTO.getId());
            employee.setName(employeeDTO.getName());
            employee.setDayOfWeeks(employeeDTO.getDaysAvailable());

            if (employeeDTO.getSkills() != null && !employeeDTO.getSkills().isEmpty()) {
                employee.setEmployeeSkills(employeeDTO.getSkills());
            }

            return employeeRepository.save(employee);

    }

    @Override
    public void updateEmployeeAvailability(Set<DayOfWeek> daysAvailable,Long employeeID) {

        Employee employee = employeeRepository.getOne(employeeID);
        if(employee!=null){
          employee.setDayOfWeeks(daysAvailable);
          employeeRepository.save(employee);
        }

    }

    @Override
    public Employee retrieveEmployeeByID(Long employeeID) {
        return employeeRepository.getOne(employeeID);
    }

    @Override
    public List<Employee> retrieveEmployeeService(EmployeeRequestDTO employeeDTO) {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().filter(employee -> {
            List<DayOfWeek> availableDays = employee.getDayOfWeeks()
                    .stream()
                    .filter(dayOfWeek -> dayOfWeek == employeeDTO.getDate().getDayOfWeek())
                    .collect(Collectors.toList());
            return employee.getDayOfWeeks().containsAll(availableDays);
        }).collect(Collectors.toList())
                .stream()
                .filter(employee -> employee.getEmployeeSkills().containsAll(employeeDTO.getSkills()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
