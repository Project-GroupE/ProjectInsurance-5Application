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

package com.example.repository;

import com.example.entity.Settlement;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Serializable> {

	List<Settlement> findByUserUserId(Integer userId);
}
