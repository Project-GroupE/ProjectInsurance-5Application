/*
 * add your task as well as functionality here
 * task : 833 -> Develop a web service that retrieves policy details for a given Driver/User
 * developed by Sairaj
 * functionality : fetch/retrieves policy for given user 
 */

package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Policy;
import com.example.entity.User;
import com.example.service.PolicyService;
import com.example.service.UserService;

// All RestAPIs are centralized into below restController class

@RestController
public class UserRestController {
	//added by Sairaj to fetch userWithPolicy
	@Autowired
	private UserService userService;
	
	//added by Aniket to save userWithPolicy
	@Autowired
	private PolicyService policyService;
	
	/*
	 *  saveUserWithPolicies() -> added by Aniket
	 *  this method save details of requested user with policies
	 *  url=http://localhost:8181/saveUserWithPolicies	
	 */
	@PostMapping("/saveUserWithPolicies")
	public User saveUserWithPolicies(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		List<Policy> policyList = user.getPolicyList();
		for (Policy policy1 : policyList) {
			policy1.setUserId(user.getUserId());
			policyService.savePolicy(policy1);
		}
		return user1;
	}	
	/*
	 *  getUserWithPolicies() -> added by sairaj
	 *  this method fetch details of requested user with policies
	 *  URL -> http://localhost:8181/getUserWithPolicies/2
	 */
	@GetMapping("/getUserWithPolicies/{userId}")
	public User getUserWithPolicies(@PathVariable Integer userId) {
		User user1=userService.getUser(userId);
		return user1;
	}
}
