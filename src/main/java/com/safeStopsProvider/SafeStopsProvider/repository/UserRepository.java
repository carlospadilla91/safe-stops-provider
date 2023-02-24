package com.safeStopsProvider.SafeStopsProvider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safeStopsProvider.SafeStopsProvider.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	User findByUsername(String username);

}
