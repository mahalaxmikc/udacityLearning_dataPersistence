package com.udacity.jdnd.course3.critter.entities;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate date;

    @ManyToMany
    private Set<Employee> employeeList;

    @ManyToMany
    private  Set<Pet>  petList;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    public Schedule() {
    }

    public Schedule(Long id, LocalDate date, Set<Employee> employeeList, Set<Pet> petList, Set<EmployeeSkill> activities) {
        this.id = id;
        this.date = date;
        this.employeeList = employeeList;
        this.petList = petList;
        this.activities = activities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Set<Pet> getPetList() {
        return petList;
    }

    public void setPetList(Set<Pet> petList) {
        this.petList = petList;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
