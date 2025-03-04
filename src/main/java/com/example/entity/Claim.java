/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 */

package com.example.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer claimId;

	private Double claimAmount;
	private Date claimDate;
	private String claimStatus; // Pending, Approved, Denied

	// Added by siddhi - Many-to-One: A Claim is linked to a single Policy
	@ManyToOne
	@JoinColumn(name = "policy_id", nullable = false)
	private Policy policy; // Foreign key reference to Policy

	// Added by siddhi - One-to-Many: A Claim can have multiple Settlements
	@JsonManagedReference
	@OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
	private List<Settlement> settlements;

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public List<Settlement> getSettlements() {
		return settlements;
	}

	public void setSettlements(List<Settlement> settlements) {
		this.settlements = settlements;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", claimStatus=" + claimStatus + ", policy=" + policy + ", settlements=" + settlements + "]";
	}
}
