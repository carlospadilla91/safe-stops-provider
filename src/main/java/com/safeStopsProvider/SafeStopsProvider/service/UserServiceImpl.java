package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeStopsProvider.SafeStopsProvider.model.User;
import com.safeStopsProvider.SafeStopsProvider.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void createUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
