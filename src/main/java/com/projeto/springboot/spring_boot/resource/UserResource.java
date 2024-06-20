package com.projeto.springboot.spring_boot.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.springboot.spring_boot.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1,"Nahtanm", "email", "189231283", "2381273");
		return ResponseEntity.ok().body(user);
	}
	
}
