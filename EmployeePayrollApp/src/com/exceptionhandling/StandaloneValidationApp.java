package com.exceptionhandling;

import java.util.Scanner;
import com.exceptionhandling.ValidationException;

public class StandaloneValidationApp {

    public void runValidationFlow(Scanner sc) {
        System.out.println("\n=== INPUT VALIDATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            ValidationService.validateEmployeeId(empId);

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            ValidationService.validateEmail(email);

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            ValidationService.validatePhone(phone);

            System.out.print("Create Password: ");
            String password = sc.nextLine();
            ValidationService.validatePassword(password);

            System.out.println("\n[Success] All inputs are VALID. Registration/Login can proceed.");

        } catch (ValidationException ex) {
            // Single catch block handles ALL child validation failures!
            System.out.println("\nValidation Failed: ");
            System.out.println("-> " + ex.getMessage());
        }
    }
}