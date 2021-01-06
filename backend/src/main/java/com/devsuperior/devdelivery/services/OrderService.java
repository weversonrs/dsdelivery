package com.devsuperior.devdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devdelivery.dto.OrderDTO;
import com.devsuperior.devdelivery.entities.Order;
import com.devsuperior.devdelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> products = repository.findOrderWithProducts();
		return products.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
	}

}
