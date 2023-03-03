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
	public void save(User user) {
		userRepo.save(user);
		
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public Boolean existsByUsername(String username) {
		return userRepo.existsByUsername(username);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return userRepo.existsByEmail(email);
	}

}
