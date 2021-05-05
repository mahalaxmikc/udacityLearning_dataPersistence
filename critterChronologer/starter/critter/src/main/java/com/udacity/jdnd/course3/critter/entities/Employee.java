package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends User {

    @ElementCollection
    private Set<EmployeeSkill> employeeSkills;

    @ElementCollection
    private Set<DayOfWeek> dayOfWeeks ;

    public Employee() {
    }

    public Employee( String name, Set<EmployeeSkill> employeeSkills, Set<DayOfWeek> dayOfWeeks) {
        setName(name);
        this.employeeSkills = employeeSkills;
        this.dayOfWeeks = dayOfWeeks;
    }
}
