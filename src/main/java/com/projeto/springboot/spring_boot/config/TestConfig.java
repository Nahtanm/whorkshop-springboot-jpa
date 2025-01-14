package com.projeto.springboot.spring_boot.config;

import java.time.Instant;
import java.util.Arrays;

import com.projeto.springboot.spring_boot.entities.*;
import com.projeto.springboot.spring_boot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.springboot.spring_boot.entities.enums.OrderStatus;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderIntemRepository orderIntemRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2024-07-01T13:31:03Z"), user1, OrderStatus.DELIVERED);
		Order order2 = new Order(null, Instant.parse("2024-07-01T13:31:03Z"), user2, OrderStatus.CANCELED);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategoria().add(cat2);
		p2.getCategoria().add(cat1);
		p2.getCategoria().add(cat3);
		p3.getCategoria().add(cat3);
		p4.getCategoria().add(cat3);
		p5.getCategoria().add(cat2);

		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPreco());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPreco());
		OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPreco());
		OrderItem oi4 = new OrderItem(order2, p5, 2, p5.getPreco());

		Payment pay1 = new Payment(null, Instant.parse("2024-07-01T15:31:03Z"),order1);
		order1.setPayment(pay1);

		orderRepository.saveAll(Arrays.asList(order1));
		orderIntemRepository.saveAll(Arrays.asList(oi2,oi1,oi3,oi4));

		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
	}
	
	
}
