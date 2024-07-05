package com.projeto.springboot.spring_boot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.springboot.spring_boot.entities.Product;
import com.projeto.springboot.spring_boot.services.ProductService;


@RestController
@RequestMapping(value="/produtos")
public class ProducResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> listProduct = productService.findAll();
		
		return ResponseEntity.ok().body(listProduct);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product product = productService.findById(id);
	
		return ResponseEntity.ok().body(product);
	}
	
}
