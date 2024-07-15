package com.projeto.springboot.spring_boot.repositories;

import com.projeto.springboot.spring_boot.entities.OrderItem;
import com.projeto.springboot.spring_boot.entities.pk.OrderIntemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderIntemRepository extends JpaRepository<OrderItem, Long> {
}
