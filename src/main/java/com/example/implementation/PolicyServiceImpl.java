/*
 * add your task as well as functionality here
 */

package com.example.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Policy;
import com.example.repository.PolicyRepository;
import com.example.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{
	@Autowired
	private PolicyRepository policyRepository;
	
	/*
	 * savePolicy() -> added by Aniket
	 * this method is use to save policy.
	 */
	@Override
	public Policy savePolicy(Policy policy) {
		return policyRepository.save(policy);
		
	}


}
