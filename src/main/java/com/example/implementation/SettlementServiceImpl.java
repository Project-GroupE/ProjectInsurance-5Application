/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 * 
 * task : 823 -> design new webservice for add settlement
 * developed by Siddhi
 * functionality :To save settlement details 
 * 
 * task : 177 -> Design web service to get the settlement details
 * developed by Siddhi
 * functionality : Fetch settlement details 
 *               -> fetch all settlement applied by user(As per UI task 1211 & 1197)
 */

package com.example.implementation;

import com.example.entity.Claim;
import com.example.entity.Settlement;
import com.example.entity.User;
import com.example.exception.SettlementNotFoundException;
import com.example.exception.ClaimNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.ClaimRepository;
import com.example.repository.SettlementRepository;
import com.example.repository.UserRepository;
import com.example.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private SettlementRepository settlementRepository;

	@Autowired
	private UserRepository userRepository;

	/*
	 * ✅ Add Settlement once claim is approved
	 * Developed by Siddhi
	 */
	@Override
	public Settlement addSettlement(Settlement settlement) {
		// ✅ Get Claim ID from Request Body
		Integer claimId = settlement.getClaim().getClaimId();
		Integer userId = settlement.getUser().getUserId();

		// ✅ 1. Check if Claim Exists or Throw Exception
		Claim claim = claimRepository.findById(claimId)
				.orElseThrow(() -> 
				new ClaimNotFoundException("Claim not found with id: " + claimId));

		// ✅ 2. Check if Claim is Approved or Throw Exception
		if (!"Approved".equalsIgnoreCase(claim.getClaimStatus())) {
			throw new RuntimeException("Settlement can only be added for approved claims");
		}

		// ✅ 3. Check if User Exists or Throw Exception
		User user = userRepository.findById(userId)
				.orElseThrow(() -> 
				new UserNotFoundException("User not found with id: " + userId));

		// ✅ 4. Set Data Manually
		settlement.setClaim(claim);
		settlement.setUser(user);
		settlement.setSettlementDate(new Date());
		settlement.setSettlementStatus("Pending");
		settlement.setPaymentReference("REF" + System.currentTimeMillis());

		// ✅ 5. Save and Return Settlement
		return settlementRepository.save(settlement);
	}

	/*
	 * ✅ Fetch All Settlements (No Filter)
	 * Developed by Siddhi
	 */
	@Override
	public List<Settlement> getAllSettlements() {
		return settlementRepository.findAll();
	}

	/*
	 * ✅ Fetch Settlements by User ID
	 * Developed by Siddhi
	 */
	@Override
	public List<Settlement> getSettlementsByUserId(Integer userId) {
		// ✅ Check if User Exists or Throw Exception
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

		// ✅ Fetch All Settlements by User ID
		List<Settlement> settlements = settlementRepository.findByUserUserId(userId);

		// ✅ Check if No Settlement Exists
		if (settlements.isEmpty()) {
			throw new SettlementNotFoundException("No settlement found for user id: " + userId);
		}
		return settlements;
	}


	/*
	 * ✅ Fetch Settlement by Settlement ID
	 * Developed by Siddhi
	 */
	@Override
	public Settlement getSettlementById(Integer settlementId) {
		return settlementRepository.findById(settlementId)
				.orElseThrow(() -> 
				new SettlementNotFoundException("Settlement not found with id: " + settlementId));
	}
}
