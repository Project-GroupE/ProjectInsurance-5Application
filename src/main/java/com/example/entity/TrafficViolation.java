package com.example.entity;

//Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
//developed by Aniket
//functionality : to save user details with TrafficViolation and Vehicle
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trafficvoilation")
public class TrafficViolation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String violationType;
	private Double fineAmount;
	@Column(nullable = false)
	private LocalDate violationDate;

	// Added by Aniket - relation many TrafficViolations have one user
	@ManyToOne
	@JoinColumn(name = "user_Id_FK")
	@JsonIgnoreProperties({ "policyList", "trafficViolationList", "vehicleList" })
	private User user;
	// Added by Aniket-one vehicle involved in multiple violation
	@ManyToOne(optional = true)
	@JoinColumn(name = "vehicle_id_fk", referencedColumnName = "id", nullable = true)
	private Vehicle vehicle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public Double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(Double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public LocalDate getViolationDate() {
		return violationDate;
	}

	public void setViolationDate(LocalDate violationDate) {
		this.violationDate = violationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "TrafficViolation [id=" + id + ", violationType=" + violationType + ", fineAmount=" + fineAmount
				+ ", violationDate=" + violationDate + ", user=" + user + ", vehicle=" + vehicle + "]";
	}

}
