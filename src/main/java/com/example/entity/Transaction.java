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
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer transactionId; // Primary key
	
	private Double transactionAmount;
	private Date transactionDate;
	private String transactionStatus; // Active, Expired, Inactive
	
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", transactionStatus=" + transactionStatus + "]";
	}
}
