/*
 * add your task as well as functionality here
 */

package com.example.service;

import com.example.entity.Policy;

public interface PolicyService {
	/*
	 * saveUser() -> added by Aniket
	 * saveUser() method use to save policy for each requested user
	 */
	public Policy savePolicy(Policy policy);
}