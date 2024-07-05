package com.projeto.springboot.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.springboot.spring_boot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
