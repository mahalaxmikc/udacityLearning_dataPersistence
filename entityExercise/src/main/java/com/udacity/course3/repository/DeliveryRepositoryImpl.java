package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.Plant;
import com.udacity.course3.dto.RecipientAndPrice;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

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



    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    // One possible way to solve this - query a list of Plants with deliveryId matching
    // the one provided and sum their prices.
    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
