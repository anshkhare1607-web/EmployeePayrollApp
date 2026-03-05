
package com.ui;

import java.util.Scanner;
import java.io.IOException;
import java.nio.*;
import java.nio.file.*;

import com.userregistration.*;
import com.authentication.*;
import com.payroll.*;
import com.dashboard.*;

public class MenuController {
    private Scanner scanner;
    private AuthenticationService authService;
    private RegistrationService registrationService;
    private PayRollService payrollService;
    private PaySlipDownloadService downloadService;
    private DashboardService dashboardService;

    // setting up services
    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.authService = new AuthenticationService();
        this.registrationService = new RegistrationService(authService);
        this.payrollService = new PayRollService();
        this.downloadService = new PaySlipDownloadService();
        this.dashboardService = new DashboardService();
    }

    // the main loop 
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== EMPLOYEE PAYROLL SYSTEM ===");
            System.out.println("1. Register New Employee (UC1)");
            System.out.println("2. Login (UC2)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // go do the registration 
                    registrationService.registerNewEmployee();
                    break;
                case "2":
                    // login helper below
                    handleLoginFlow();
                    break;
                case "3":
             
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
 
    }

    // helper method so that start() method doesn't get too long 
    private void handleLoginFlow() {
        System.out.println("\n=== EMPLOYEE AUTHENTICATION & LOGIN ===\n");
        // login
        Session session = authService.login();
        
        // checking if session time out or not
        if (session != null && !session.isExpired()) {
            showDashboard(session);
        } else if (session != null && session.isExpired()) {
            System.out.println("Session has expired. Please login again.");
        }
    }

    private void showDashboard(Session session) {
       
        boolean loggedIn = true;
        
        while (loggedIn) {
            // showing the role
            System.out.println("\n=== " + session.getRole() + " DASHBOARD ===");
            System.out.println("1. Generate Payslip (UC3)");
            System.out.println("2. Print / Download Payslip (UC4)");
            System.out.println("3. View Analytics Dashboard (UC5)");
            
            // managers extra options
            if (session.getRole().equals("MANAGER")) {
                System.out.println("4. View All Employees");
                System.out.println("5. Logout");
            } else {
                // regular employees see logout as option 3
                System.out.println("4. Logout");
            }
            
            System.out.print("Select an option: ");
            String dashChoice = scanner.nextLine();
            
            if (dashChoice.equals("1")) {
                // payslip generation
                payrollService.runPayslipFlow();
            } else if (dashChoice.equals("2")) {
                // payslip download
                downloadService.runDownloadFlow(scanner);
              
            } 
            else if(dashChoice.equals("3")) {
            	dashboardService.runDashboardFlow(scanner);
            }
            else if (session.getRole().equals("MANAGER") && dashChoice.equals("3")) {
                System.out.println("\n--- List of All Employees ---");
                try {
                    // Prinitng all employees list
                    Files.lines(Paths.get("employee_data.txt")).forEach(System.out::println);
                } catch (IOException e) {
                    // file probably doesn't exist yet, no big deal
                    System.out.println("No employee records found.");
                }
            } else if ((session.getRole().equals("MANAGER") && dashChoice.equals("5")) || 
                       (!session.getRole().equals("MANAGER") && dashChoice.equals("4"))) {
                loggedIn = false;
                System.out.println("\nLogged out successfully.");
            } else {
                // they hit the wrong key again
                System.out.println("\nInvalid option.");
            }
        }
    }
}
