package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;

public interface SafeStopService {
	public SafeStop findById(Long id);
	public void save(SafeStop safeStop);
	public void update(SafeStop safeStop);
	public void delete(Long id);
	public List<SafeStop> findAll();

}
