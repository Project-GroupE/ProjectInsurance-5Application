/*
 * add your task as well as functionality here
 * Task 172 -> Design API to add the transaction details for each user after paying the premium 
 * Task 173 -> Design API to update the transection details for each user after paying the premium 
 * Task 174 -> Design API to get the transection details for each user after paying the premium 
 * designed by Namrata
 */

package com.example.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId; // Primary key

	private Double transactionAmount;
	private LocalDate transactionDate;// change Date as LocalDate by namrata
	private String transactionStatus; // Paid, unpaid

	// 30 to 37 added by Namrata
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Policy getPolicy() {
		return policy;
	}

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

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate localDate) {
		this.transactionDate = localDate;
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

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}
