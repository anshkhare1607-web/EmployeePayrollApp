/*
 * Authentication service class for authenticating user using password hash
 */


package com.authentication;
import java.util.*;
import com.userregistration.*;

public class AuthenticationService {
    private Map<String, User> users = new HashMap<>(); //for storing user and its credentials
    private int maxAttempts = 3; //max attempts for security purpose

    public AuthenticationService() {
        users.put("emp1", new RegularEmployee("emp1", "Emp@1234")); //hardcoded ids for testing purpose
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    public Session login() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter username: ");
            String inputUsername = sc.nextLine();
            
            System.out.print("Enter password: ");
            String inputPassword = sc.nextLine();

            User user = users.get(inputUsername);

            if (user != null && user.authenticate(inputUsername, inputPassword)) { //authenticating input details
                System.out.println("Login successful!");
                showDashboard(user.getRole());
                return new Session(inputUsername); //creating new session for the user
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempts remaining: " + (maxAttempts - attempts));
            }
        }
        
        System.out.println("Account locked due to multiple failed login attempts.");
        return null;
    } 

    private void showDashboard(String role) {
        System.out.println("\n--- Dashboard ---");
        System.out.println();
        if (role.equals("MANAGER")) {
            System.out.println("Manager DashBoard");
            System.out.println("\nManage Employees | View Reports | Update Profile");
        } else {
            System.out.println("Employee Dashboard");
            System.out.println("\nView Payslip | Update Profile");
        }
        System.out.println("-----------------\n");
    }
}