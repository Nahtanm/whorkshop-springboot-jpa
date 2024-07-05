package com.projeto.springboot.spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springboot.spring_boot.entities.Product;
import com.projeto.springboot.spring_boot.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		
		List<Product> listProduct = productRepository.findAll();
		
		return listProduct;
	}
	
	public Product findById(Long id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		return product.get();
	}
	
}
