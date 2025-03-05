/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 */

package com.example.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "settlement")
public class Settlement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer settlementId;

	// Added by siddhi - many-to-one relationship where multiple settlements are
	// linked to a single claim
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "claim_id", nullable = false)
	private Claim claim;

	private Double settledAmount;
	private Date settlementDate;
	private String settlementStatus; // Pending, Paid
	private String settlementMethod; // Bank Transfer, Cheque, Cash
	private String paymentReference; // Payment reference number

	public Integer getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(Integer settlementId) {
		this.settlementId = settlementId;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Double getSettledAmount() {
		return settledAmount;
	}

	public void setSettledAmount(Double settledAmount) {
		this.settledAmount = settledAmount;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public String getSettlementMethod() {
		return settlementMethod;
	}

	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	@Override
	public String toString() {
		return "Settlement [settlementId=" + settlementId + ", settledAmount=" + settledAmount + ", settlementDate="
				+ settlementDate + ", settlementStatus=" + settlementStatus + ", paymentReference=" + paymentReference
				+ "]";
	}
}
