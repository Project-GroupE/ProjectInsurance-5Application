package com.example.exception;

/*
 * ClaimNotFoundException is used when a claim is not found in the database
 * developed by Siddhi
 */
public class ClaimNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClaimNotFoundException(String message) {
		super(message);
	}
}
