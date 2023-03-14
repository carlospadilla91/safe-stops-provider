package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;

public interface SafeStopService {
	public SafeStop findById(Long id);
	public SafeStop save(SafeStop safeStop);
	public SafeStop update(Long id, SafeStop safeStop);
	public void delete(Long id);
	public List<SafeStop> findAll();

}
