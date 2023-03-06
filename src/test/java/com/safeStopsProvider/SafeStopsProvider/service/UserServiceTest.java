package com.safeStopsProvider.SafeStopsProvider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.safeStopsProvider.SafeStopsProvider.repository.UserRepository;

@ActiveProfiles("test")
@SpringBootTest(classes = {RepositoryTestConfig.class, UserService.class})
public class UserServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private UserService service;
	
	@Autowired UserRepository mockDao;

}
