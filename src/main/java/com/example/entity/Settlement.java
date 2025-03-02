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
@Table(name="settlement")
public class Settlement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer settlementId; // Primary key
	
	private Double settledAmount;
	private Date sttlementDate;
	private String settlementStatus; // Pending, Paid	
	private String paymentReference; // BankTransfer, Check
	
	
	public Integer getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(Integer settlementId) {
		this.settlementId = settlementId;
	}
	public Double getSettledAmount() {
		return settledAmount;
	}
	public void setSettledAmount(Double settledAmount) {
		this.settledAmount = settledAmount;
	}
	public Date getSttlementDate() {
		return sttlementDate;
	}
	public void setSttlementDate(Date sttlementDate) {
		this.sttlementDate = sttlementDate;
	}
	public String getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	@Override
	public String toString() {
		return "Settlement [settlementId=" + settlementId + ", settledAmount=" + settledAmount + ", sttlementDate="
				+ sttlementDate + ", settlementStatus=" + settlementStatus + ", paymentReference=" + paymentReference
				+ "]";
	}
}
