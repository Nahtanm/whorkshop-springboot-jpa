package com.projeto.springboot.spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springboot.spring_boot.entities.Order;
import com.projeto.springboot.spring_boot.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order findById(Long id) {
		
		Optional<Order> order = orderRepository.findById(id);
		
		return order.get();
	}
	
	public List<Order> findAll(){
		
		List<Order> orderList = orderRepository.findAll();
		
		return orderList;
		
	}
	
}
