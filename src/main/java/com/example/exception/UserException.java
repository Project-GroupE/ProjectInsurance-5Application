/*
 * UserException exception is use to store the UserNotFoundException's message
 */
package com.example.exception;

public class UserException {
	
	private final String msg;

	public UserException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
