/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 */

package com.example.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Claim;
import com.example.exception.ClaimNotFoundException;
import com.example.repository.ClaimRepository;
import com.example.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	/*
	 * insertClaim() -> added by Siddhi
	 * This method is used to add a new claim record to the database.
	 */
	@Override
	public Claim insertClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	/*
	 * getClaimById() -> added by Siddhi
	 * This method is used to fetch claim details by using claim ID.
	 * If the claim is not found, it throws ClaimNotFoundException.
	 */
	@Override
	public Claim getClaimById(Integer claimId) {
		return claimRepository.findById(claimId)
				.orElseThrow(() -> new ClaimNotFoundException("Claim not found with ID: " + claimId));
	}
}
