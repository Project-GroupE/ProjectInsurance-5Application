/*
 * add your task as well as functionality here
 */

package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Transaction;
import com.example.service.TransactionService;

// All RestAPIs are centralized into below restController class

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {

	//Added By Namrata Start
	
	@Autowired
    private TransactionService transactionService;
	//http://localhost:8181/transaction/create?policyId=102&amount=5000.00
    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestParam Long policyId, @RequestParam Double amount) {
        Transaction transaction = transactionService.createTransaction(policyId, amount);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
    //http://localhost:8181/transaction/update/2   **need to pass query parameter amount 8000
    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestParam Double amount) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, amount);
        return ResponseEntity.ok(updatedTransaction);
    }
    //http://localhost:8181/transaction/policy/102
    @GetMapping("/policy/{policyId}")
    public ResponseEntity<List<Transaction>> getTransactionsByPolicy(@PathVariable Long policyId) {
        List<Transaction> transactions = transactionService.getTransactionsByPolicy(policyId);
        return ResponseEntity.ok(transactions);
    }//End
}
