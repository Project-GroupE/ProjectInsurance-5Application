package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Handles JSON status codes with Settlement exception messages
 * developed by Siddhi
 */
@ControllerAdvice
public class SettlementExceptionHandler {

	@ExceptionHandler(value = {SettlementNotFoundException.class})
	public ResponseEntity<Object> handleSettlementNotFoundException(SettlementNotFoundException exception) {
		return new ResponseEntity<>(new SettlementException(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {ClaimNotFoundException.class})
	public ResponseEntity<Object> handleClaimNotFoundException(ClaimNotFoundException exception) {
		return new ResponseEntity<>(new SettlementException(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleSettlementRuntimeException(RuntimeException exception) {
		return new ResponseEntity<>(new SettlementException(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
