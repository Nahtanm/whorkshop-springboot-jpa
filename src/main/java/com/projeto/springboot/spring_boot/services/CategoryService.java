package com.projeto.springboot.spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springboot.spring_boot.entities.Category;
import com.projeto.springboot.spring_boot.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		
		List<Category> listCategory = categoryRepository.findAll();
		
		return listCategory;
	}
		
	public Category findById(Long id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		
		return category.get();
		
	} 
	
}
