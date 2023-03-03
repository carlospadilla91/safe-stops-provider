package com.safeStopsProvider.SafeStopsProvider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeStopsProvider.SafeStopsProvider.model.User;
import com.safeStopsProvider.SafeStopsProvider.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		
		List<User> users = service.findAll();
		
		if(users.isEmpty()) {
			System.out.println("No users found");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	

}
