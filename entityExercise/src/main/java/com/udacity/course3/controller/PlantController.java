package com.udacity.course3.controller;

import com.udacity.course3.data.Plant;
import com.udacity.course3.dto.PlantDTO;
import com.udacity.course3.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;


    public PlantDTO getPlantDTO(String name){
         return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    public Plant getPlantEntity(String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }


}
