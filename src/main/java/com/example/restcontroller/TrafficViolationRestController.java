package com.example.restcontroller;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.TrafficViolation;
import com.example.service.TrafficViolationService;

@RestController
@RequestMapping("/trafficviolations")
public class TrafficViolationRestController {
	@Autowired
	private TrafficViolationService trafficViolationService;

	// Add traffic Violation for user
	// url=http://localhost:8181/trafficviolations/addTrafficViolation/{userId}
	@PostMapping("/addTrafficViolation/{userId}")
	public ResponseEntity<TrafficViolation> addTrafficViolation(@PathVariable("userId") Integer userId,
			@RequestBody TrafficViolation trafficViolation) {
		TrafficViolation savedViolation = trafficViolationService.addViolation(userId, trafficViolation);
		return ResponseEntity.ok(savedViolation);
	}

	// Fetch all traffic violations for a user(without pagination)
	// url=http://localhost:8181/trafficviolations/getTrafficViolations/user/{userId}
	@GetMapping("/getTrafficViolations/user/{userId}")
	public List<TrafficViolation> getViolationsByUserId(@PathVariable("userId") Integer userId) {
		return trafficViolationService.getViolationsByUserId(userId);
	}

	// Fetch Traffic Violations for a user (with pagination & sorting)
	// url:
	// http://localhost:8181/trafficviolations/getTrafficViolations/user/{userId}/paginated
	@GetMapping("/getTrafficViolations/user/{userId}/paginated")
	public Page<TrafficViolation> getViolationsByUserIdPaginated(@PathVariable("userId") Integer userId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size,
			@RequestParam(defaultValue = "violationDate") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return trafficViolationService.getViolationsByUserId(userId, pageable);
	}

	// url=http://localhost:8181/trafficviolations/getAllTrafficViolations
	// url=http://localhost:8181/trafficviolations/getAllTrafficViolations?page=0&size=5&sortBy=violationDate->for pagination
	@GetMapping("/getAllTrafficViolations")
	public Page<TrafficViolation> getAllTrafficViolations(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size,
			@RequestParam(defaultValue = "violationDate") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return trafficViolationService.getTrafficViolations(pageable);
	}

}
