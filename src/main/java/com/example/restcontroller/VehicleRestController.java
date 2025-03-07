package com.example.restcontroller;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleRestController {
	@Autowired
	private VehicleService vehicleService;

	// url=http://localhost:8181/vehicles/addVehicle/{userId}
	@PostMapping("/addVehicle/{userId}")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer userId) {
		Vehicle savedVehicle = vehicleService.addVehicle(vehicle, userId);
		return ResponseEntity.ok(savedVehicle);
	}
}
