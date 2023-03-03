package com.safeStopsProvider.SafeStopsProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeStopsProvider.SafeStopsProvider.model.User;
import com.safeStopsProvider.SafeStopsProvider.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/auth")
@RestController
public class AuthorizationController {
	
	@Autowired
	private UserService service;
	
	// creates user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		
		if(service.existsByUsername(user.getUsername())) {
			System.out.println("Failed to create user. Username exists");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		if(service.existsByEmail(user.getEmail())) {
			System.out.println("Failed to create user. Email already exists.");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		System.out.println("New user created");
		service.save(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}
	
	// user login
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		
		
		
		if(service.existsByUsername(user.getUsername())) {
			
			User activeUser = service.findByUsername(user.getUsername());
			
			if(activeUser.getPassword().equals(user.getPassword())) {
				System.out.println("User: " + user.getUsername() + " has successfully logged in.");
				return new ResponseEntity<User>(activeUser, HttpStatus.OK);
			} else {
				System.out.println("Login failed.");
				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

}
