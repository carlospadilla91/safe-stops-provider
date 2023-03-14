package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeStopsProvider.SafeStopsProvider.exception.NotFoundException;
import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;
import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;

@Service
public class SafeStopServiceImpl implements SafeStopService {
	
	@Autowired
	private SafeStopRepository safeStopRepo;
	
	@Override
	public SafeStop findById(Long id) {
		return safeStopRepo.findById(id).orElseThrow(() -> new NotFoundException("SafeStop not found", id));
	}

	@Override
	public SafeStop save(SafeStop safeStop) {
		return safeStopRepo.save(safeStop);
	}

	@Override
	public SafeStop update(Long id, SafeStop safeStop) {
		
		SafeStop current = findById(id);
		
		current.setName(safeStop.getName());
		current.setDescription(safeStop.getDescription());
		current.setRating(safeStop.getRating());
		
		System.out.println(current);
		return safeStopRepo.save(current);
	}

	@Override
	public void delete(Long id) {
		safeStopRepo.deleteById(id);
	}

	@Override
	public List<SafeStop> findAll() {
		return safeStopRepo.findAll();
	}
	

}
