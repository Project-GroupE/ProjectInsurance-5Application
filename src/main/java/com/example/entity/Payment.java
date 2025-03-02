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
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId; // Primary key
	
	private Double amountPaid;
	private Date paymentDate;
	private String paymentStatus; // Pending, Completed	
	private String paymentMethod; // Debit card, credit card
	
	
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
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
