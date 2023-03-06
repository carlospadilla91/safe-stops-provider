package com.safeStopsProvider.SafeStopsProvider.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;
import com.safeStopsProvider.SafeStopsProvider.repository.UserRepository;

@Profile("test")
@Configuration
public class RepositoryTestConfig {
	
	@Bean
	@Primary
	public SafeStopRepository safeStopRepo() {
		return Mockito.mock(SafeStopRepository.class);
	}
	
	@Bean
	@Primary
	public UserRepository userRepo() {
		return Mockito.mock(UserRepository.class);
	}

}
