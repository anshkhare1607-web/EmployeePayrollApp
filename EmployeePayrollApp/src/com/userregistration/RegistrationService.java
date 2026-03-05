package com.userregistration;

import java.util.Scanner;
import com.exceptionhandling.*;
import com.validatorclass.*;
import java.io.IOException;


//Registartion service class
public class RegistrationService {
    

    public void registerNewEmployee() {
        System.out.println("=== EMPLOYEE REGISTRATION ===");
        Scanner sc = new Scanner(System.in); 

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            Validator.validateEmpId(empId);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            // Coordinate object creation (Composition)
            UserAccount account = new UserAccount(username, password); 
            Employee emp = new Employee(empId, name, email, phone, account);
            
            // Persist the data
            emp.persist();

            System.out.println("\nEmployee Registered Successfully:");
            System.out.println(emp);

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }
    }
}
