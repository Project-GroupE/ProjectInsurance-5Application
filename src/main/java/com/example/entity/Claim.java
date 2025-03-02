/*
 * add your task as well as functionality here
 */

package com.example.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="claim")
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer claimId; // Primary key
	
	private Double claimAmount;
	private Date claimDate;
	private String claimStatus; // Pending, Approved, Denied
	
	
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
	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", claimStatus=" + claimStatus + "]";
	}
}
