package com.exceptionhandling;

//for validation exception handling
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
