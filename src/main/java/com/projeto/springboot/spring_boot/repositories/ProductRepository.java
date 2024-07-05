package com.projeto.springboot.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.springboot.spring_boot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
