/*
 * EMPLOYEE PAYROLL MANAGEMENT APP
 * 
 * Use Case 03 - PaySlip Generation
 * @author : Developer
 * version : 3.0
 * 
 */


package com.main;

import java.util.Scanner;
import com.userregistration.RegistrationService;
import com.authentication.AuthenticationService;
import com.authentication.Session;
import com.payroll.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AuthenticationService authService = new AuthenticationService();
        RegistrationService registrationService = new RegistrationService(authService);
        PayRollService payrollService = new PayRollService();
        
        boolean running = true;

        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Register New Employee");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    registrationService.registerNewEmployee();
                    break;
                case 2:
                    System.out.println("\n=== EMPLOYEE AUTHENTICATION & LOGIN ===\n");
                    Session session = authService.login();
                    
                    if (session != null && !session.isExpired()) {
                        boolean loggedIn = true;
                        
                        // User is logged in, show restricted menu
                        while (loggedIn) {
                            System.out.println("\n=== RESTRICTED DASHBOARD ===");
                            System.out.println("1. Generate Payslip");
                            System.out.println("2. Logout");
                            System.out.print("Select an option: ");
                            
                            int dashChoice = -1;
                            try {
                                dashChoice = sc.nextInt();
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input.");
                                continue;
                            }
                            
                            if (dashChoice == 1) {
                                payrollService.runPayslipFlow();
                            } else if (dashChoice == 2) {
                                loggedIn = false;
                                System.out.println("\nLogged out successfully.");
                            } else {
                                System.out.println("\nInvalid option.");
                            }
                        }
                    } else if (session != null && session.isExpired()) {
                        System.out.println("Session has expired. Please login again.");
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