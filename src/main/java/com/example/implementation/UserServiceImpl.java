/*
 * add your task as well as functionality here
 * task : 833 -> Develop a web service that retrieves policy details for a given Driver/User
 * developed by Sairaj
 * functionality : fetch/retrieves policy for given user 
 */

package com.example.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	/*
	 * getUser() -> added by sairaj
	 * this method is use to fetch user records by using user Id.
	 */
	@Override
	public User getUser(Integer userId) {
	
		User user=userRepository.findByUserId(userId);
		if (user == null) {
			// UserNotFoundException exception is use to 'if user is not present'
			throw new UserNotFoundException("Record is not present into database : "+userId);
		}
		return user;
	}
}
