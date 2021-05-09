package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.dtos.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entities.Schedule;

import java.util.List;

public interface ScheduleService {


    public Schedule createSchedule(ScheduleDTO scheduleDTO) ;
    public List<Schedule> getAllSchedules();

    public  List<Schedule> getSchedulesForPetId(long petId);
    public List<Schedule> getSchedulesForEmployee(long employeeId);
    public List<Schedule> getSchedulesForCustomer(long customerId);



}
