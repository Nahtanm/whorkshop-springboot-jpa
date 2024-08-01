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

	public void delete(Long id){
		userRepository.deleteById(id);
	}

	public User update(Long id, User user){
		User user_1 = userRepository.getReferenceById(id);
		updateData(user_1, user);
		return userRepository.save(user_1);
	}

	public void updateData(User user_1, User user){
		user_1.setName(user.getName());
		user_1.setEmail(user.getEmail());
		user_1.setPhone(user.getPhone());
	}

}
