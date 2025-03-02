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
@Table(name="policy")
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
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", insuranceCompanyName=" + insuranceCompanyName + ", policyHolderName="
				+ policyHolderName + ", policyType=" + policyType + ", policyStatus=" + policyStatus
				+ ", coverageAmount=" + coverageAmount + ", premiumAmount=" + premiumAmount + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
