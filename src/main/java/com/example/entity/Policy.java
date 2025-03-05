/*
 * add your task as well as functionality here
 * task : 833 -> Develop a web service that retrieves policy details for a given Driver/User
 * developed by Sairaj
 * functionality : fetch/retrieves policy for given user
 * 
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 * 
 * Task : 171 -> Design service to save the policy for each requested user 
 * developed by Aniket
 * functionality : to save user details with policy.
 * 
 * Task : 1154 -> Design Webservice to save user for insurance/Policy 
 * developed by Aniket
 * functionality : to save user details with policy.
 */

package com.example.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyId; // Primary key

	private String insuranceCompanyName;
	private String policyHolderName;
	private String policyType; // Life, General(car, medical, etc.)
	private String policyStatus; // Active, Expired, Inactive
	private Double coverageAmount;
	private Double premiumAmount;
	private Date startDate;
	private Date endDate;

	// Added by sairaj - relation many policies have one user
	@JoinColumn(name = "user_Id_FK", insertable = false, updatable = false)
	@ManyToOne
	private User user;

	@Column(name = "user_Id_FK")
	private Integer userId;// added by Aniket

	// Added by siddhi - @OneToMany → Indicates that one Policy can have many Claims
	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	private List<Claim> claims;

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// Getter and Setter added for userId by Aniket
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", insuranceCompanyName=" + insuranceCompanyName + ", policyHolderName="
				+ policyHolderName + ", policyType=" + policyType + ", policyStatus=" + policyStatus
				+ ", coverageAmount=" + coverageAmount + ", premiumAmount=" + premiumAmount + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", user=" + user + ", userId=" + userId + ", claims=" + claims + "]";
	}

}
