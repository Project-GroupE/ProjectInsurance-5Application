package com.example.repository;
//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Serializable> {
	boolean existsByVehicleNumber(String vehicleNumber);
}