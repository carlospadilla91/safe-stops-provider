package com.safeStopsProvider.SafeStopsProvider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;
import com.safeStopsProvider.SafeStopsProvider.repository.SafeStopRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/safeStops")
public class SafeStopController {
	
	@Autowired
	SafeStopRepository safeStopRepo;
	
	@GetMapping("/safeStops")
	public ResponseEntity<List<SafeStop>> getAllSafeStops(@RequestParam(required = false) String title) {
		try {
			List<SafeStop> safeStops = new ArrayList<SafeStop>();

			if (title == null) {
				safeStopRepo.findAll().forEach(safeStops::add);
			}

			if (safeStops.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(safeStops, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
