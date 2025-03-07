package com.example.repository;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TrafficViolation;

public interface TrafficViolationRepository extends JpaRepository<TrafficViolation, Serializable> {
	// fetch violations by user (without pagination)
	public List<TrafficViolation> findByUserUserId(Integer userId);

	// fetch violations by user with pagination and sorting
	Page<TrafficViolation> findByUserUserId(Integer userId, Pageable pageable);

	// fetch violations by vehicle pagination and sorting
	Page<TrafficViolation> findByVehicleId(Integer vehicleId, Pageable pageable);

	// Fetch violations by user and vehicle with pagination and sorting
	Page<TrafficViolation> findByUserUserIdAndVehicleId(Integer userId, Integer vehicleId, Pageable pageable);
	
	// Method for fetching traffic violations by userId with sorting
    List<TrafficViolation> findByUserUserId(Integer userId, Sort sort);

	// Fetch all violations with pagination and sorting
	Page<TrafficViolation> findAll(Pageable pageable);
}
