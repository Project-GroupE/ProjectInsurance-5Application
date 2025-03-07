package com.example.service;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import com.example.entity.Vehicle;

public interface VehicleService {
	public Vehicle addVehicle(Vehicle vehicle, Integer userId);

}
