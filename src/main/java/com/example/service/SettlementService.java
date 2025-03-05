/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add settlement details once claim is done 
 * task : 177 -> Design web service to get settlement details
 * developed by Siddhi
 * functionality : Provides methods to add and retrieve settlement details.
 */

package com.example.service;

import com.example.entity.Settlement;

public interface SettlementService {

	/*
	 * addSettlement() -> added by Siddhi
	 * This method adds settlement details once a claim is processed.
	 */
	Settlement addSettlement(Settlement settlement);

	/*
	 * getSettlementById() -> added by Siddhi
	 * This method retrieves settlement details using the settlement ID.
	 */
	Settlement getSettlementById(Integer settlementId);
}
