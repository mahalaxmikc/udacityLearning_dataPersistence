package com.udacity.course3.service;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.dto.RecipientAndPrice;
import com.udacity.course3.repository.DeliveryJPARepository;
import com.udacity.course3.repository.DeliveryRepository;
import com.udacity.course3.repository.DeliveryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepositoryImpl deliveryRepository;
    @Autowired
    private DeliveryJPARepository deliveryJPARepository;

    public Long saveDelivery(Delivery delivery){
      /* Delivery delivery1=deliveryJPARepository.save(delivery);
        return delivery1.getId();*/
       delivery.getPlantList().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();

    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }



}
