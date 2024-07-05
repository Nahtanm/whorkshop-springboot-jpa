package com.projeto.springboot.spring_boot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.springboot.spring_boot.entities.Category;
import com.projeto.springboot.spring_boot.services.CategoryService;

@RestController
@RequestMapping(value="/categoria")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> listCategory = categoryService.findAll();
		
		return ResponseEntity.ok().body(listCategory);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category category = categoryService.findById(id);
		
		return ResponseEntity.ok().body(category);
	}
	
}
