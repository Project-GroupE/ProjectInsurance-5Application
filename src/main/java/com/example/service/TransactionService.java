/*
 * add your task as well as functionality here
 */

package com.example.service;

import java.util.List;

import com.example.entity.Transaction;


public interface TransactionService {
//Added By Namrata Start
	public Transaction createTransaction(Long policyId, Double amount);
	
	public Transaction updateTransaction(Long transactionId, Double amount);
	
	public List<Transaction> getTransactionsByPolicy(Long policyId);//End
}
