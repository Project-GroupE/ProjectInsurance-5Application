/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 */

package com.example.implementation;

import com.example.entity.Claim;
import com.example.entity.Settlement;
import com.example.exception.SettlementNotFoundException;
import com.example.exception.ClaimNotFoundException;
import com.example.repository.ClaimRepository;
import com.example.repository.SettlementRepository;
import com.example.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SettlementServiceImpl implements SettlementService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private SettlementRepository settlementRepository;

	/*
	 * addSettlement() -> added by Siddhi
	 * This method is used to add settlement details once a claim is processed.
	 * It ensures that settlement is only added for approved claims.
	 * It sets the settlement date, status, and generates a payment reference.
	 */
	@Override
	public Settlement addSettlement(Settlement settlement) {
		// Fetch the claim associated with the settlement request
		Claim claim = claimRepository.findById(settlement.getClaim().getClaimId())
				.orElseThrow(() -> 
				// Throws ClaimNotFoundException if the claim does not exist in the database
				new ClaimNotFoundException("Claim not found with id: " + settlement.getClaim().getClaimId()));

		// Ensure that settlement can only be added for claims that have been approved
		if (!"Approved".equalsIgnoreCase(claim.getClaimStatus())) {
			throw new RuntimeException("Settlement can only be added for approved claims");
		}

		// Set the claim reference, settlement date, status, and generate a unique payment reference
		settlement.setClaim(claim);
		settlement.setSettlementDate(new Date());
		settlement.setSettlementStatus("Pending");
		settlement.setPaymentReference("REF" + System.currentTimeMillis());

		// Save the settlement details into the database and return the saved entity
		return settlementRepository.save(settlement);
	}

	/*
	 * getSettlementById() -> added by Siddhi
	 * This method is used to fetch settlement details using settlement ID.
	 * If the settlement is not found, it throws SettlementNotFoundException.
	 */
	@Override
	public Settlement getSettlementById(Integer settlementId) {
		return settlementRepository.findById(settlementId)
				.orElseThrow(() -> 
				// Throws SettlementNotFoundException if the settlement does not exist in the database
				new SettlementNotFoundException("Settlement not found with id: " + settlementId));
	}
}
