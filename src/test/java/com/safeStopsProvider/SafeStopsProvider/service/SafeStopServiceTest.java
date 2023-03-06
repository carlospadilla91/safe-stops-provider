package com.safeStopsProvider.SafeStopsProvider.service;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;


@ActiveProfiles("test")
@SpringBootTest(classes = {RepositoryTestConfig.class, SafeStopService.class})
public class SafeStopServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private SafeStopService service;
	
	@Autowired
	private SafeStopRepository mockDao;
	
	@BeforeMethod
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

}
