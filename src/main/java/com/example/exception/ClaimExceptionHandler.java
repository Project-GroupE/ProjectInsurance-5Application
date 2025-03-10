/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality :->Adds settlement details for a claim once the claim is processed.
 *                ->fetch all claims applied by user(As per UI Task(1210,1200) 
 */
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

	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<>(new ClaimException(exception.getMessage()), HttpStatus.NOT_FOUND);
	}
}
