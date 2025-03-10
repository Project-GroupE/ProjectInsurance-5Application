/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality :->Adds settlement details for a claim once the claim is processed.
 *                ->fetch all claims applied by user(As per UI Task(1210,1200) 
 */

package com.example.restcontroller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Claim;
import com.example.entity.Policy;
import com.example.entity.User;
import com.example.repository.PolicyRepository;
import com.example.repository.UserRepository;
import com.example.service.ClaimService;

// All claim-related RestAPIs are centralized in this RestController class

@RestController
@RequestMapping("/claims")
public class ClaimRestController {

	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PolicyRepository policyRepository;

	/*
	 * addClaim() -> added by Siddhi
	 * This method is used to add a new claim to the system.
	 * It accepts claim details in the request body and saves them to the database.
	 * Use 'POST' Method
	 * URL ->  http://localhost:8181/claims/add
	 */
	@PostMapping("/add")
	public Claim addClaim(@RequestBody Map<String, Object> requestBody) {
		// ✅ Extract User ID and Policy ID from Request Body
		Integer userId = (Integer) ((Map<String, Object>) requestBody.get("user")).get("userId");
		Integer policyId = (Integer) ((Map<String, Object>) requestBody.get("policy")).get("policyId");

		// ✅ Create Claim Object Manually
		Claim claim = new Claim();
		claim.setClaimAmount(Double.valueOf(requestBody.get("claimAmount").toString()));
		claim.setClaimDate(new Date());
		claim.setClaimStatus(requestBody.get("claimStatus").toString());

		// ✅ Fetch User and Policy from the Database
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

		Policy policy = policyRepository.findById((long) policyId)
				.orElseThrow(() -> new RuntimeException("Policy not found with ID: " + policyId));

		// ✅ Set User and Policy to Claim
		claim.setUser(user);
		claim.setPolicy(policy);

		// ✅ Now Save the Claim
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

	/*
	 * getAllClaimsByUserId() -> added by Siddhi
	 * This method retrieves all claims for a specific user using the user ID.
	 * Use 'GET' Method
	 * URL ->  http://localhost:8181/claims/user/{userId}
	 * for ex. http://localhost:8181/claims/user/1
	 */
	@GetMapping("/user/{userId}")
	public List<Claim> getAllClaimsByUserId(@PathVariable Integer userId) {
		return claimService.getAllClaimsByUserId(userId);
	}

	/*
	 * getAllClaims() -> added by Siddhi
	 * This method retrieves all claims available in the system.
	 * It provides a list of all claims irrespective of the user.
	 * Use 'GET' Method
	 * URL ->  http://localhost:8181/claims/all
	 * ]
	 */
	@GetMapping("/all")
	public List<Claim> getAllClaims() {
		return claimService.getAllClaims();
	}
}
