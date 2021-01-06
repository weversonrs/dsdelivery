package com.devsuperior.devdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.devdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
