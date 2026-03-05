/*
 * EMPLOYEE PAYROLL MANAGEMENT APP
 * 
 * Use Case 02 - Employee Authentication & Login
 * @author : Developer
 * version : 2.0
 * 
 */


package com.main;

import java.util.Scanner;
import com.userregistration.RegistrationService;
import com.authentication.AuthenticationService;
import com.authentication.Session;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RegistrationService registrationService = new RegistrationService();
		AuthenticationService authService = new AuthenticationService();
		boolean running = true;

		while (running) {
			System.out.println("\n=== EMPLOYEE PAYROLL SYSTEM ===");
			System.out.println("1. Register New Employee");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Select an option: ");

			int choice = -1;
			try {
				choice = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
				continue;
			}

			switch (choice) {
			case 1:
				registrationService.registerNewEmployee(); 
				break;
			case 2:
				System.out.println("\n=== EMPLOYEE AUTHENTICATION & LOGIN ===");
				Session session = authService.login();
				if (session != null) {
					if (!session.isExpired()) {
						System.out.println(session.toString());
					} else {
						System.out.println("Session has expired. Please login again.");
					}
				}
				break;
			case 3:
				running = false;
				System.out.println("Exiting system. Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
