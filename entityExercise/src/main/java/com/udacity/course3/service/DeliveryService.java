package com.udacity.course3.service;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.repository.DeliveryRepository;
import com.udacity.course3.repository.DeliveryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepositoryImpl deliveryRepository;

    public Long saveDelivery(Delivery delivery){
     delivery.getPlantList().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }


}
