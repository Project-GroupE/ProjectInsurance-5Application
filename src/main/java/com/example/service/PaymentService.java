/*
 * add your task as well as functionality here
 */

package com.example.service;

import com.example.entity.Payment;

public interface PaymentService 
{

	//Added by Namrata  
		public Payment savePayment(Long policyId, Double amount,String paymethod);

	
}