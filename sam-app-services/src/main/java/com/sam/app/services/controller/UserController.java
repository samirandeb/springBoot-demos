package com.sam.app.services.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sam.app.services.model.User;
import com.sam.app.services.repository.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/user")
	public Iterable<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") String id) {
		return userRepo.findById(new BigInteger(id)).orElse(null);
	}
}
