package com.example.exception;

/*
 * ClaimException stores the error message for Claim-NotFound exceptions
 * developed by Siddhi
 */
public class ClaimException {

	private final String msg;

	public ClaimException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
