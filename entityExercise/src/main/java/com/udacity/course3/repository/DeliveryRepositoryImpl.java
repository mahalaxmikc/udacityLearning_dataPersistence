package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
     entityManager.persist(delivery);

    }

    public Delivery find(Long id) {

        return entityManager.find(Delivery.class,id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
      entityManager.detach(entityManager.find(Delivery.class,id));
    }
}
