/*
 * add your task as well as functionality here
 */

package com.example.implementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Policy;
import com.example.entity.Policy.PolicyStatus;
import com.example.entity.Transaction;
import com.example.exception.PolicyNotActiveException;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PolicyRepository;
import com.example.repository.TransactionRepository;
import com.example.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	//Added by Nmarata to get updat and add transaction
	@Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PolicyRepository policyRepository;
    
    
    public Transaction createTransaction(Long policyId, Double amount) {
        // Check if the policy is active
        Policy policy = policyRepository.findByPolicyIdAndStatus(policyId, PolicyStatus.ACTIVE)
                .orElseThrow(() -> new PolicyNotActiveException("Policy is not active"));

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(amount);
        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionStatus("PAID");
        transaction.setPolicy(policy);

        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long transactionId, Double amount) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        transaction.setTransactionAmount(amount);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByPolicy(Long policyId) {
        return transactionRepository.findByPolicy_PolicyId(policyId);
    }
}
