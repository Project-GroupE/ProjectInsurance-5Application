/*
 * add your task as well as functionality here
 */

package com.example.service;

import com.example.entity.User;

public interface UserService {
	/*
	 * getUser() -> added by Aniket
	 * saveUser() method use to save user details with policy
	 */
	public User saveUser(User user);

	/*
	 * getUser() -> added by sairaj
	 * getUser() method use to get user details
	 */
	public User getUser(Integer userId);
}
