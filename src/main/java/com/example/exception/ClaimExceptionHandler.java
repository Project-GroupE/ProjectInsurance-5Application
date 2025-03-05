package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Handles JSON status codes with Claim exception messages
 * developed by Siddhi
 */
@ControllerAdvice
public class ClaimExceptionHandler {

	@ExceptionHandler(value = {ClaimNotFoundException.class})
	public ResponseEntity<Object> handleClaimNotFoundException(ClaimNotFoundException exception) {
		return new ResponseEntity<>(new ClaimException(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleClaimRuntimeException(RuntimeException exception) {
		return new ResponseEntity<>(new ClaimException(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
