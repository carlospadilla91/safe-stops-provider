package com.safeStopsProvider.SafeStopsProvider.service;

import java.util.List;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;

public interface SafeStopService {
	public SafeStop findById(Long id);
	public void saveSafeStop(SafeStop safeStop);
	public void updateSafeStop(SafeStop safeStop);
	public void deleteSafeStop(Long id);
	public List<SafeStop> getAllSafeStops();

}
