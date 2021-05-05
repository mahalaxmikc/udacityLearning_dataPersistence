package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.Plant;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class PlantRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PlantRepository plantRepository;

    @Test
     public void  testPriceLessThan(){
            Plant plant= testEntityManager.persist(new Plant("Dill Leaf", new BigDecimal("3.45")));
             testEntityManager.persist(new Plant("methi leaf",new BigDecimal("1.45")));

             List<Plant> plantLists= plantRepository.findByPriceLessThan(BigDecimal.valueOf(3.00));
             Assertions.assertEquals(1,plantLists.size(),"size");
             Assertions.assertEquals(1,plant.getId(),"ID");
     }

     @Test
     public void testDeliveryCompleted(){

         Plant plant= testEntityManager.persist(new Plant("Dill Leaf", new BigDecimal("3.45")));
         Delivery delivery= testEntityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));

         delivery.setPlantList(Lists.newArrayList(plant));
         plant.setDelivery(delivery);

         delivery.setCompleted(true);

         Assertions.assertEquals(true,delivery.getCompleted(),"delivery_completed");

     }
}
