package com.validatorclass;

import com.exceptionhandling.ValidationException;

//validator class for email phone number and empid
public class Validator {
	
	//example@gmail.com format
    public static void validateEmail(String email) throws ValidationException {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Invalid Email Format.");
        }
    }
    
    //must start with 6,7,8 or 9. 
    public static void validatePhone(String phone) throws ValidationException {
        if (!phone.matches("[6-9][0-9]{9}")) {
            throw new ValidationException("Phone must be 10 digits starting with 6, 7, 8, or 9.");
        }
    }
    
    //must follow EMP-XXXX where X is a digit.
    public static void validateEmpId(String empId) throws ValidationException {
        if (!empId.matches("EMP-[0-9]{4}")) {
            throw new ValidationException("Employee ID must follow EMP-XXXX format.");
        }
    }
}