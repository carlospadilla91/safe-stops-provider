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
		return safeStopRepo.findById(id).get();
	}

	@Override
	public void save(SafeStop safeStop) {
		safeStopRepo.save(safeStop);
	}

	@Override
	public void update(SafeStop safeStop) {
		safeStopRepo.save(safeStop);
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
