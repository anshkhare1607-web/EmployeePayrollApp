/*
 * EMPLOYEE PAYROLL MANAGEMENT APP
 * 
 * Use Case 01 - Employee registartion.
 * @author : Developer
 * version : 1.0
 * 
 */


package com.main;

import com.userregistration.*;
import com.exceptionhandling.*;
import com.validatorclass.*;

public class Main {
	public static void main(String[] args) {
		
		//Calling the registration service
		RegistrationService service = new RegistrationService();
		service.registerNewEmployee();
	}

}
