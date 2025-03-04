/*
 * UserExceptionHandler -> handls the json status code with UserNotFoundException's message
 */

package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> messageToJson(UserNotFoundException userNotFoundException){
		
		UserException userException = new UserException(userNotFoundException.getMessage());
		return new ResponseEntity<Object>(userException, HttpStatus.NOT_FOUND);
	}
}
