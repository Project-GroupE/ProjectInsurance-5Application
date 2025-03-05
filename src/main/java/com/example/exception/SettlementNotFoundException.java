package com.example.exception;

/*
 * SettlementNotFoundException is used when a settlement is not found in the database
 * developed by Siddhi
 */
public class SettlementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SettlementNotFoundException(String message) {
		super(message);
	}
}
