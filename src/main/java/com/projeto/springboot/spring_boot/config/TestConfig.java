package com.projeto.springboot.spring_boot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.springboot.spring_boot.entities.Order;
import com.projeto.springboot.spring_boot.entities.User;
import com.projeto.springboot.spring_boot.entities.enums.OrderStatus;
import com.projeto.springboot.spring_boot.repositories.OrderRepository;
import com.projeto.springboot.spring_boot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2024-07-01T13:31:03Z"), user1, OrderStatus.DELIVERED);
		Order order2 = new Order(null, Instant.parse("2024-07-01T13:31:03Z"), user2, OrderStatus.CANCELED);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2));
		
	}
	
	
}
