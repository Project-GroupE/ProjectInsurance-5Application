/*
 * add your task as well as functionality here
 * task : 175 -> Design web service to add the settlement details once claim is done 
 * developed by Siddhi
 * functionality : Adds settlement details for a claim once the claim is processed.
 * 
 * task : 823 -> design new webservice for add settlement
 * developed by Siddhi
 * functionality :To save settlement details 
 * 
 * task : 177 -> Design web service to get the settlement details
 * developed by Siddhi
 * functionality : Fetch settlement details 
 *               -> fetch all settlement applied by user(As per UI task 1211 & 1197)
 * 
 */

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

	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<>(new SettlementException(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleSettlementRuntimeException(RuntimeException exception) {
		return new ResponseEntity<>(new SettlementException(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
