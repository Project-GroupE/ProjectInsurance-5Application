/*
 * add your task as well as functionality here
 * 831 -> Develop a webservice to add For Insurance/Policy
 */

package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Policy;
import com.example.service.PolicyService;

// All RestAPIs are centralized into below restController class

@RestController
public class PolicyRestController {

	@Autowired
	private PolicyService policyService;

	/*
	 * added by Gokarna - addPolicy() method URL - http://localhost:8181/addPolicy
	 * Postman Request - { "insuranceCompanyName": "ABC Insurance",
	 * "policyHolderName": "John Doe", "policyType": "Life", "policyStatus":
	 * "Active", "coverageAmount": 500000, "premiumAmount": 1200, "startDate":
	 * "2024-01-01", "endDate": "2034-01-01", "status": "ACTIVE", "userId":1 }
	 * 
	 * 
	 */
	@PostMapping("/addPolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		Policy savedPolicy = policyService.savePolicy(policy);
		return ResponseEntity.ok(savedPolicy);
	}

}
