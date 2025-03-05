/*
 * add your task as well as functionality here
 * developed by Siddhi
 * functionality : Provides APIs to add a new claim and retrieve claim details by ID.
 */

package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Claim;
import com.example.service.ClaimService;

// All claim-related RestAPIs are centralized in this RestController class

@RestController
@RequestMapping("/claims")
public class ClaimRestController {

	@Autowired
	private ClaimService claimService;

	/*
	 * addClaim() -> added by Siddhi
	 * This method is used to add a new claim to the system.
	 * It accepts claim details in the request body and saves them to the database.
	 * Use 'POST' Method
	 * URL ->  http://localhost:8181/claims/add
	 */
	@PostMapping("/add")
	public Claim addClaim(@RequestBody Claim claim) {
		return claimService.insertClaim(claim);
	}

	/*
	 * getClaimById() -> added by Siddhi
	 * This method retrieves claim details using the claim ID.
	 * It removes settlement details from the response to ensure clean data.
	 * Use 'GET' Method
	 * URL ->  http://localhost:8181/claims/{claimId}
	 * for ex. http://localhost:8181/claims/1
	 */
	@GetMapping("/{claimId}")
	public Claim getClaimById(@PathVariable Integer claimId) {
		Claim claim = claimService.getClaimById(claimId);

		// Remove settlements from response to prevent unnecessary data exposure
		claim.setSettlements(null);

		return claim;
	}
}
