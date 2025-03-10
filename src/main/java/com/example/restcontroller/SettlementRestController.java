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
 * 
 */

package com.example.restcontroller;

import com.example.entity.Settlement;
import com.example.service.SettlementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// All settlement-related RestAPIs are centralized in this RestController class

@RestController
@RequestMapping("/settlements")
public class SettlementRestController {

	@Autowired
	private SettlementService settlementService;

	/*
	 * ✅ Add settlement details once a claim is processed
	 * POST -> http://localhost:8181/settlements/add
	 */
	@PostMapping("/add")
	public Settlement addSettlement(@RequestBody Settlement settlement) {
		return settlementService.addSettlement(settlement);
	}

	/*
	 * ✅ Fetch all settlements without any filter
	 * GET -> http://localhost:8181/settlements/all
	 */
	@GetMapping("/all")
	public List<Settlement> getAllSettlements() {
		return settlementService.getAllSettlements();
	}

	/*
	 * ✅ Fetch settlement by Settlement ID
	 * GET -> http://localhost:8181/settlements/{settlementId}
	 */
	@GetMapping("/{settlementId}")
	public Settlement getSettlementById(@PathVariable Integer settlementId) {
		return settlementService.getSettlementById(settlementId);
	}

	/*
	 * ✅ Fetch all settlements applied by a specific user
	 * GET -> http://localhost:8181/settlements/user/{userId}
	 */
	@GetMapping("/user/{userId}")
	public List<Settlement> getSettlementsByUserId(@PathVariable Integer userId) {
		return settlementService.getSettlementsByUserId(userId);
	}
}
