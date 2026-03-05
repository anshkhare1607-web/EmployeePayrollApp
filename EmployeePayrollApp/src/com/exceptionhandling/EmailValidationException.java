package com.exceptionhandling;
// email validation exception

public class EmailValidationException extends ValidationException{
	public EmailValidationException(String message) {
		super(message);
	}
}
