package com.example.customer.exceptionhandling;

public class NoCustomersFoundException extends RuntimeException{

	public NoCustomersFoundException(String msg) {
		super(msg);
	}
	
}
