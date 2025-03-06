/*
 * add your task as well as functionality here
 */

package com.example.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Policy;
import com.example.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Serializable>{
	//Added by namrata
	 List<Transaction> findByPolicy_PolicyId(Long policyId);
}
