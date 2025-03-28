/*
 * add your task as well as functionality here
 * task : 833 -> Develop a web service that retrieves policy details for a given Driver/User
 * developed by Sairaj
 * functionality : fetch/retrieves policy for given user  
 * 
 * Task : 171 -> Design service to save the policy for each requested user 
 * developed by Aniket
 * functionality : to save user details with policy.
 * 
 * Task : 1154 -> Design Webservice to save user for insurance/Policy 
 * developed by Aniket
 * functionality : to save user details with policy.
 * 
 * Task : 832 -> get pagination and sorting for Traffic Violation and Vehicle microservice 
 * developed by Aniket
 * functionality : to save user details with TrafficViolation and Vehicle
 *  
 *  Task : 177 -> Design web service to get the settlement details
 * developed by Siddhi
 * functionality : Fetch settlement details 
 *               -> fetch all settlement applied by user(As per UI task 1211 & 1197)
 */

package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId; // Primary key

	private String firstName;
	private String lastName;
	private String userEmail;
	private Long userPhone;
	private String userAddress;
	private String userGender;

	// Added by sairaj - relation one user has many policies
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Policy> policyList;

	// Added by Aniket - relation one user has many Traffic Violations
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user") // added by Aniket-to ignore unwanted fields
	private List<TrafficViolation> trafficViolationList;

	// Added by Aniket - relation one user has many vehicles
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Vehicle> vehicleList;

	// Added by Siddhi - relation one user has many claims
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Claim> claimList;

	// Getters and Setters
	// Added by Siddhi - claimList
	@JsonIgnore // Prevents recursion from claim
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Claim> getClaimList() {
		return claimList;
	}

	// Added by Siddhi - Mapping Settlement with User
	@JsonIgnore //Prevents recursion from settlement
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Settlement> settlementList;

	// Getters and Setters
	public List<Settlement> getSettlementList() {
		return settlementList;
	}

	public void setSettlementList(List<Settlement> settlementList) {
		this.settlementList = settlementList;
	}


	public void setClaimList(List<Claim> claimList) {
		this.claimList = claimList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@JsonManagedReference
	public List<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}

	public List<TrafficViolation> getTrafficViolationList() {
		return trafficViolationList;
	}

	public void setTrafficViolationList(List<TrafficViolation> trafficViolationList) {
		this.trafficViolationList = trafficViolationList;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", userGender=" + userGender
				+ ", policyList=" + policyList + ", trafficViolationList=" + trafficViolationList + ", vehicleList="
				+ vehicleList + "]";
	}

}
