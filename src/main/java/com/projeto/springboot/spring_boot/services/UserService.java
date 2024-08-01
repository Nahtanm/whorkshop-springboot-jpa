package com.projeto.springboot.spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.springboot.spring_boot.entities.User;
import com.projeto.springboot.spring_boot.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		
		return userRepository.findAll();
		
	}
	
	public User findById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		return user.get();
		
	}

	public User inserir(User user){

		return userRepository.save(user);

	}
	
}
