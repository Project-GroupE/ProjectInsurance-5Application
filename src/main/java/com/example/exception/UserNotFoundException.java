/*
 * UserNotFoundException exception is use to 'if user is not present' 
 */

package com.example.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
