package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;
import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;

@Service
public class SafeStopServiceImpl implements SafeStopService {
	
	@Autowired
	private SafeStopRepository safeStopRepo;
	
	@Override
	public SafeStop findById(Long id) {
		return safeStopRepo.getById(id);
	}

	@Override
	public void saveSafeStop(SafeStop safeStop) {
		safeStopRepo.save(safeStop);
	}

	@Override
	public void updateSafeStop(SafeStop safeStop) {
		safeStopRepo.save(safeStop);
	}

	@Override
	public void deleteSafeStop(Long id) {
		safeStopRepo.deleteById(id);
	}

	@Override
	public List<SafeStop> getAllSafeStops() {
		return safeStopRepo.findAll();
	}
	

}
