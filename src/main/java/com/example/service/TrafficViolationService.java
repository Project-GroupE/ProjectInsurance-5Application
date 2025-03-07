package com.example.service;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.TrafficViolation;

public interface TrafficViolationService {
	// Add traffic violation for specific user
	public TrafficViolation addViolation(Integer userId, TrafficViolation trafficVoilation);

	// Retrieve all traffic violations for a user (Without pagination)
	public List<TrafficViolation> getViolationsByUserId(Integer userId);

	// Retrieve traffic violations for a user with pagination and sorting
	Page<TrafficViolation> getViolationsByUserId(Integer userId, Pageable pageable);

	// Retrieve all traffic violations with Pagination and sorting
	public Page<TrafficViolation> getTrafficViolations(Pageable pageable);

}
