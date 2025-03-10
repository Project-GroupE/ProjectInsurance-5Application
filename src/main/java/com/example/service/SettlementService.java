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

package com.example.service;


import com.example.entity.Settlement;

import java.util.List;



public interface SettlementService {
	
	//To add a new settlement in the database.
	Settlement addSettlement(Settlement settlement);
	
	//To fetch a settlement by its ID.
	Settlement getSettlementById(Integer settlementId);
	
	//To fetch all settlements from the database.
	List<Settlement> getAllSettlements();

	//To fetch all settlements applied by a user.
	List<Settlement> getSettlementsByUserId(Integer userId);
}
