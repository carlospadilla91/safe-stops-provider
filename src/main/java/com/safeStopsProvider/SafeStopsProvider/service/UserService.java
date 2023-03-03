package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import com.safeStopsProvider.SafeStopsProvider.model.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getAllUsers();

}
