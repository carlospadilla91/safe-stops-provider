package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import com.safeStopsProvider.SafeStopsProvider.model.User;

public interface UserService {
	public User save(User user);
	public List<User> findAll();
	public User findByUsername(String username);
	public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);

}
