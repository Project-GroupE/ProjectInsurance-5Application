package com.example.implementation;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.Vehicle;
import com.example.repository.UserRepository;
import com.example.repository.VehicleRepository;
import com.example.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Vehicle addVehicle(Vehicle vehicle, Integer userId) {
		// Check if the user exists
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));

		// Check if the vehicle number already exists
		if (vehicleRepository.existsByVehicleNumber(vehicle.getVehicleNumber())) {
			throw new RuntimeException("Vehicle with number " + vehicle.getVehicleNumber() + " already exists!");
		}

		// Assign the user to the vehicle
		vehicle.setUser(user);

		// Save the vehicle
		return vehicleRepository.save(vehicle);
	}

}
