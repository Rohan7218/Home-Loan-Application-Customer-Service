package com.example.customer.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoCustomerFoundException.class)
	public ResponseEntity<String> handleNoCustomerFoundExceptionhandler(NoCustomerFoundException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(NoCustomersFoundException.class)
	public ResponseEntity<String> handleNoCustomersFoundExceptionhandler(NoCustomersFoundException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
