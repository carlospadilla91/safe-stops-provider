package com.safeStopsProvider.SafeStopsProvider.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.safeStopsProvider.SafeStopsProvider.exception.NotFoundException;
import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;
import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;


@ActiveProfiles("test")
@SpringBootTest(classes = {RepositoryTestConfig.class, SafeStopServiceImpl.class, SafeStopService.class})
public class SafeStopServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private SafeStopService service;
	
	@Autowired
	private SafeStopRepository mockDao;
	
	private final List<SafeStop> safeStops = new ArrayList<>();
	
	@BeforeClass
	public void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		SafeStop safeStop1 = new SafeStop(1L, "Valero", "Great coffee", 4L);
		this.safeStops.add(safeStop1);
		
		SafeStop safeStop2 = new SafeStop(2L, "Shell", "Rude cashier", 2L);
		this.safeStops.add(safeStop2);
		
		SafeStop safeStop3 = new SafeStop(3L, "Buc-ees", "THE BEST!", 5L);
		this.safeStops.add(safeStop3);
	}
	
	@Test
	public void whenListIsCalled_ShouldReturnAllSafeStops() {
		when(mockDao.findAll()).thenReturn(this.safeStops);
		List<SafeStop> mockList = service.findAll();
		assertEquals(safeStops, mockList);
	}
	
	@Test
	public void whenGivenId_ShouldReturnSafeStop() {
		SafeStop safeStop = this.safeStops.get(0);
		when(mockDao.findById(safeStop.getId())).thenReturn(Optional.of(safeStop));
		SafeStop mockSafeStop = service.findById(safeStop.getId());
		assertEquals(safeStop, mockSafeStop);
	}
	
	@Test(expectedExceptions = NotFoundException.class)
	public void whenIdNotFound_ShouldThrowException() {
		when(mockDao.findById(77L)).thenReturn(Optional.empty());
		service.findById(77L);
		verify(mockDao).findById(77L);
		
	}
	
	@Test
	public void whenSaveSafeStop_ShouldReturnSafeStop() {
		
		SafeStop safeStop = new SafeStop();
		safeStop.setName("QT");
		safeStop.setDescription("Awesome");
		safeStop.setRating(5L);
		
		when(mockDao.save(Mockito.any(SafeStop.class))).thenReturn(safeStop);
		
		SafeStop created = service.save(safeStop);
		
		assertEquals(safeStop, created);
		verify(mockDao).save(safeStop);
	}
	
	@Test
	public void whenUpdatingSafeStop_ShouldReturnUpdateSafeStop() {
		SafeStop safeStop = new SafeStop();
		safeStop.setId(4L);
		safeStop.setName("QT");
		safeStop.setDescription("Fast service");
		safeStop.setRating(4L);
		
		SafeStop updated = new SafeStop();
		//updated.setId(1L);
		updated.setName("QT");
		updated.setDescription("Best ever");
		updated.setRating(5L);
		
		when(mockDao.findById(Mockito.anyLong())).thenReturn(Optional.of(safeStop));
		System.out.println(mockDao);
		when(mockDao.save(safeStop)).thenReturn(updated);
		
		SafeStop savedSafeStop = service.update(1L, safeStop);
		
		assertEquals(savedSafeStop, updated);
		//verify(mockDao).save(Mockito.any(SafeStop.class));
		
	}
	
	@Test
	public void whenGivenId_ShouldDeleteSafeStop() {
		service.delete(this.safeStops.get(0).getId());
		verify(mockDao).deleteById(any(Long.class));
	}
	

}
