/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality :->Adds settlement details for a claim once the claim is processed.
 *                ->fetch all claims applied by user(As per UI Task(1210,1200) 
 */

package com.example.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Serializable> {
	
	// ✅ Fetch All Claims By User ID
	List<Claim> findByUserUserId(Integer userId);
	
	// ✅ Fetch All Claims By Policy ID (Corrected)
	List<Claim> findByPolicyPolicyId(Long policyId);
}
