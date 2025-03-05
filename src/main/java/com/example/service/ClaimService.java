/*
 * add your task as well as functionality here
 * developed by Siddhi
 * functionality : Provides methods to insert and fetch claim details by claim ID.
 */

package com.example.service;

import com.example.entity.Claim;

public interface ClaimService {

	/*
	 * insertClaim() -> added by Siddhi
	 * This method inserts a new claim into the system.
	 */
	Claim insertClaim(Claim claim);

	/*
	 * getClaimById() -> added by Siddhi
	 * This method retrieves claim details using the provided claim ID.
	 */
	Claim getClaimById(Integer claimId);
}
