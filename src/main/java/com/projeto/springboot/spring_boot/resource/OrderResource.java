package com.projeto.springboot.spring_boot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.springboot.spring_boot.entities.Order;
import com.projeto.springboot.spring_boot.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order order = orderService.findById(id);
		
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> orderList = orderService.findAll();
		
		return ResponseEntity.ok().body(orderList);
		
	}
	
}
