/*
 * add your task as well as functionality here
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
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId; // Primary key
	
	private Double amountPaid;
	private LocalDate paymentDate;
	private String paymentStatus; // Pending, Completed	
	private String paymentMethod; // Debit card, credit card
	
	//Added by Namrata 
	@ManyToOne
    @JoinColumn(name = "policy_id")
	private Policy policy;
	
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}//End
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate localDate) {
		this.paymentDate = localDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amountPaid=" + amountPaid + ", paymentDate=" + paymentDate
				+ ", paymentStatus=" + paymentStatus + ", paymentMethod=" + paymentMethod + "]";
	}
}
