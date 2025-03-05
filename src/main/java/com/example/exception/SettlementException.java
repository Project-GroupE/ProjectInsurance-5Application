package com.example.exception;

/*
 * SettlementException stores the error message for Settlement-NotFound exceptions
 * developed by Siddhi
 */
public class SettlementException {

	private final String msg;

	public SettlementException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
