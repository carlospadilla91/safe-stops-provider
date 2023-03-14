package com.safeStopsProvider.SafeStopsProvider.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.safeStopsProvider.SafeStopsProvider.model.User;
import com.safeStopsProvider.SafeStopsProvider.repository.UserRepository;

@ActiveProfiles("test")
@SpringBootTest(classes = {RepositoryTestConfig.class, UserServiceImpl.class, User.class })
public class UserServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	UserServiceImpl service;
	
	@Autowired 
	UserRepository mockDao;
	
	private final List<User> users = new ArrayList<>();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		User user1 = new User(1L, "user1@email.com", "user1", "password");
		this.users.add(user1);
		
		User user2 = new User(2L, "user2@email.com", "user2", "password");
		this.users.add(user2);
		
		User user3 = new User(3L, "user3@email.com", "user3", "password");
		this.users.add(user3);
	}
	
	@Test
	public void whenListIsCalled_ShouldReturnAllUsers() {
		when(mockDao.findAll()).thenReturn(this.users);
		List<User> mockList = service.findAll();
		assertEquals(users, mockList);
	}
	
	@Test
	public void whenUserIsCreated_ShouldReturnUser() {
		
		User user4 = new User();
		user4.setId(4L);
		user4.setEmail("user4@email.com");
		user4.setUsername("user4");
		user4.setPassword("password");
		
		when(mockDao.save(any(User.class))).thenReturn(user4);
		
		User userToSave = service.save(user4);
		
		verify(mockDao).save(any(User.class));
		assertEquals(userToSave, user4);
		
	}
	
	@Test
	public void whenSearchByUsername_ReturnUser() {
		when(mockDao.findByUsername("user1")).thenReturn(this.users.get(0));
		assertEquals(service.findByUsername("user1"), this.users.get(0));
		verify(mockDao).findByUsername(this.users.get(0).getUsername());
	}
	
	@Test
	public void whenExistsByEmail_ReturnBoolean() {
		when(mockDao.existsByEmail("user1@email.com")).thenReturn(true);
		assertTrue(service.existsByEmail("user1@email.com"));
		verify(mockDao).existsByEmail("user1@email.com");
	}
	
	@Test
	public void whenExistsByUsername_ReturnBoolean() {
		when(mockDao.existsByUsername("user1")).thenReturn(true);
		assertTrue(service.existsByUsername("user1"));
		verify(mockDao).existsByUsername("user1");
	}
	

}
