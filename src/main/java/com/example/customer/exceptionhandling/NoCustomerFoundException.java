package com.example.customer.exceptionhandling;

public class NoCustomerFoundException extends RuntimeException {

	public NoCustomerFoundException(String msg) {
		super(msg);
	}
	
}
