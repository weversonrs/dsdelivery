package com.devsuperior.devdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devdelivery.dto.OrderDTO;
import com.devsuperior.devdelivery.dto.ProductDTO;
import com.devsuperior.devdelivery.entities.Order;
import com.devsuperior.devdelivery.entities.OrderStatus;
import com.devsuperior.devdelivery.entities.Product;
import com.devsuperior.devdelivery.repositories.OrderRepository;
import com.devsuperior.devdelivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> products = repository.findOrderWithProducts();
		return products.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		
		for (ProductDTO productDTO : dto.getProducts()) {
			Product product = productRepository.getOne(productDTO.getId());
			order.getProducts().add(product);			
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}

}
