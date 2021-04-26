package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;

public interface DeliveryRepository {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
}
