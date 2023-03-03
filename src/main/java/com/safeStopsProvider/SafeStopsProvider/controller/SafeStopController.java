package com.safeStopsProvider.SafeStopsProvider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;
import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
@RestController
public class SafeStopController {
	
	@Autowired
	SafeStopRepository safeStopRepo;
	
	// lists safeStops
	@GetMapping("/safeStops")
	public ResponseEntity<List<SafeStop>> getAllSafeStops() {
		
		List<SafeStop> safeStops = safeStopRepo.findAll();
		
		if(safeStops.isEmpty()) {
			System.out.println("No SafeStops found");
			return new ResponseEntity<List<SafeStop>>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<List<SafeStop>>(safeStops, HttpStatus.OK);
	}
	
	// creates safeStop
	@PostMapping("/safeStops")
	public ResponseEntity<SafeStop> createNewSafeStop(@RequestBody SafeStop safeStop) {
		
		safeStopRepo.save(safeStop);
		System.out.println("Created SafeStop with id of: " + safeStop.getId());
		return new ResponseEntity<SafeStop>(safeStop, HttpStatus.OK);
	}
	
	// updates safeStop
	@PutMapping("/safeStops/{id}")
	public ResponseEntity<SafeStop> udpateSafeStop(@PathVariable("id") long id, @RequestBody SafeStop safeStop) {
		
		System.out.println("Updating SafeStop with id of: " + id);
		SafeStop currentSafeStop = safeStopRepo.findById(id).get();
		
		if(currentSafeStop == null) {
			System.out.println("SafeStop with id of: " + id + " not found");
			return new ResponseEntity<SafeStop>(HttpStatus.NOT_FOUND);
		}
		
		currentSafeStop.setName(safeStop.getName());
		currentSafeStop.setDescription(safeStop.getDescription());
		currentSafeStop.setRating(safeStop.getRating());
		
		safeStopRepo.save(currentSafeStop);
		return new ResponseEntity<SafeStop>(currentSafeStop, HttpStatus.OK);
	}
	
	// deletes safeStop
	@DeleteMapping("safeStops/{id}")
	public ResponseEntity<SafeStop> deleteSafeStop(@PathVariable("id") long id) {
		System.out.println("Deleting SafeStop with id of: " + id);
		SafeStop safeStopToDelete = safeStopRepo.getById(id);
		
		if(safeStopToDelete == null) {
			System.out.println("SafeStop with id of: " + id + " not found to delete");
			return new ResponseEntity<SafeStop>(HttpStatus.NOT_FOUND);
		}
		
		safeStopRepo.delete(safeStopToDelete);
		return new ResponseEntity<SafeStop>(HttpStatus.NO_CONTENT);
	}

}
