package com.projeto.springboot.spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.springboot.spring_boot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
