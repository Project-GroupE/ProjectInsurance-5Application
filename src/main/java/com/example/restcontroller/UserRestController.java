/*
 * add your task as well as functionality here
 * task : 833 -> Develop a web service that retrieves policy details for a given Driver/User
 * developed by Sairaj
 * functionality : fetch/retrieves policy for given user 
 */

package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

// All RestAPIs are centralized into below restController class

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	/*
	 *  getUserWithPolicies() -> added by sairaj
	 *  this method fetch details of requested user with policies
	 *  URL -> http://localhost:8181/getUser/2
	 */
	@GetMapping("/getUser/{userId}")
	public User getUserWithPolicies(@PathVariable Integer userId) {
		User user1=userService.getUser(userId);
		return user1;
	}
}
