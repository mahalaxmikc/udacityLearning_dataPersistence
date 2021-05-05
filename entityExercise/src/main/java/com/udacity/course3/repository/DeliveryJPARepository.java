package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJPARepository extends JpaRepository<Delivery,Long> {
}
