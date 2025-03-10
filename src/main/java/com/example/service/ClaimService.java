/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality :->Adds settlement details for a claim once the claim is processed.
 *                ->fetch all claims applied by user(As per UI Task(1210,1200) 
 */

package com.example.service;

import java.util.List;

import com.example.entity.Claim;

public interface ClaimService {
	
	//To insert a new claim in the database.
	Claim insertClaim(Claim claim);
	
    //To fetch a claim by its ID.
	Claim getClaimById(Integer claimId);
	
	//To fetch all claims applied by a user.
	List<Claim> getAllClaimsByUserId(Integer userId);

	//To fetch all claims from the database
	List<Claim> getAllClaims();
}
