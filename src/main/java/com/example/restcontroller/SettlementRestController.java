/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * task : 177 -> Design web service to get the settlement details
 * developed by Siddhi
 * functionality : Provides APIs to add settlement details and retrieve settlement details by ID.
 */

package com.example.restcontroller;

import com.example.entity.Settlement;
import com.example.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// All settlement-related RestAPIs are centralized in this RestController class

@RestController
@RequestMapping("/settlements")
public class SettlementRestController {

	@Autowired
	private SettlementService settlementService;

	/*
	 * addSettlement() -> added by Siddhi
	 * This method is used to add settlement details for a processed claim.
	 * It ensures settlement is added only for approved claims.
	 * Use 'POST' Method 
	 * URL ->  http://localhost:8181/settlements/add
	 */
	@PostMapping("/add")
	public Settlement addSettlement(@RequestBody Settlement settlement) {
		return settlementService.addSettlement(settlement);
	}

	/*
	 * getSettlementById() -> added by Siddhi
	 * This method retrieves settlement details using the settlement ID.
	 * If settlement is not found, it throws SettlementNotFoundException.
	 * GET
	 * URL ->  http://localhost:8181/settlements/{settlementId}
	 *For Ex.-> http://localhost:8181/settlements/1
	 */
	@GetMapping("/{settlementId}")
	public Settlement getSettlementById(@PathVariable Integer settlementId) {
		return settlementService.getSettlementById(settlementId);
	}
}
