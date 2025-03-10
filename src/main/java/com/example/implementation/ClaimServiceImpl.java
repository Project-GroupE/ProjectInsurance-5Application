/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality :->Adds settlement details for a claim once the claim is processed.
 *                ->fetch all claims applied by user(As per UI Task(1210,1200) 
 */
package com.example.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Claim;
import com.example.entity.Policy;
import com.example.entity.User;
import com.example.exception.ClaimNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.ClaimRepository;
import com.example.repository.PolicyRepository;
import com.example.repository.UserRepository;
import com.example.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Claim insertClaim(Claim claim) {

		// ✅ Check if UserId exists or not
		if (claim.getUser() == null || claim.getUser().getUserId() == null) {
			throw new RuntimeException("User ID is missing in the request body");
		}

		// ✅ Check if PolicyId exists or not
		if (claim.getPolicy() == null || claim.getPolicy().getPolicyId() == null) {
			throw new RuntimeException("Policy ID is missing in the request body");
		}

		// ✅ Fetch the User from the database
		User user = userRepository.findById(claim.getUser().getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + claim.getUser().getUserId()));

		// ✅ Fetch the Policy from the database
		Policy policy = policyRepository.findById((long) claim.getPolicy().getPolicyId())
				.orElseThrow(() -> new RuntimeException("Policy not found with ID: " + claim.getPolicy().getPolicyId()));

		// ✅ Set the User and Policy objects in the Claim manually
		claim.setUser(user);
		claim.setPolicy(policy);

		// ✅ Now save the Claim
		return claimRepository.save(claim);
	}




	@Override
	public Claim getClaimById(Integer claimId) {
		return claimRepository.findById(claimId)
				.orElseThrow(() -> new ClaimNotFoundException("Claim not found with ID: " + claimId));
	}

	@Override
	public List<Claim> getAllClaimsByUserId(Integer userId) {
		if (!userRepository.existsById(userId)) {
			throw new UserNotFoundException("User ID not found: " + userId);
		}
		return claimRepository.findByUserUserId(userId);
	}

	@Override
	public List<Claim> getAllClaims() {
		return claimRepository.findAll();
	}
}
