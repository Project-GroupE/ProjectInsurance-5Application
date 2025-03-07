package com.example.implementation;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entity.TrafficViolation;
import com.example.entity.User;
import com.example.entity.Vehicle;
import com.example.repository.TrafficViolationRepository;
import com.example.repository.UserRepository;
import com.example.repository.VehicleRepository;
import com.example.service.TrafficViolationService;

@Service
public class TrafficViolationServiceImpl implements TrafficViolationService {
	@Autowired
	private TrafficViolationRepository trafficViolationRepository;
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserRepository userRepository;

	// Add traffic violation for specific user
	@Override
	public TrafficViolation addViolation(Integer userId, TrafficViolation trafficVoilation) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("user not found with Id>>" + userId));
		trafficVoilation.setUser(user);
		// fetch the full vehicle object
		if (trafficVoilation.getVehicle() != null && trafficVoilation.getVehicle().getId() != null) {
			Vehicle vehicle = vehicleRepository.findById(trafficVoilation.getVehicle().getId())
					.orElseThrow(() -> new RuntimeException("vehicle not found"));
			trafficVoilation.setVehicle(vehicle);// set vehicle object
		}
		return trafficViolationRepository.save(trafficVoilation);
	}

	// Retrieve all traffic violations for a user (Without pagination)
	@Override
	public List<TrafficViolation> getViolationsByUserId(Integer userId) {
		return trafficViolationRepository.findByUserUserId(userId);
	}

	// Retrieve traffic violations for a user with pagination and sorting
	@Override
	public Page<TrafficViolation> getViolationsByUserId(Integer userId, Pageable pageable) {
		Sort sort = pageable.getSort().isSorted() ? pageable.getSort()
				: Sort.by(Sort.Order.desc("violationDate"), Sort.Order.desc("fineAmount"));
		Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		return trafficViolationRepository.findByUserUserId(userId, sortedPageable);
	}

	// Retrieve all traffic violations with Pagination and sorting
	@Override
	public Page<TrafficViolation> getTrafficViolations(Pageable pageable) {
		Sort sort = pageable.getSort().isSorted() ? pageable.getSort()
				: Sort.by(Sort.Order.desc("violationDate"), Sort.Order.desc("fineAmount"));
		Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		return trafficViolationRepository.findAll(sortedPageable);

	}

}
