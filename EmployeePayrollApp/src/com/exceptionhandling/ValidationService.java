
package com.exceptionhandling;

import com.exceptionhandling.*;
import java.util.regex.Pattern;

public class ValidationService {

    // Sanitizes input before validation (removes accidental spaces)
    private static String sanitize(String input) {
        return input == null ? "" : input.trim();
    }

    public static void validateEmail(String email) throws EmailValidationException {
        email = sanitize(email);
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            throw new EmailValidationException("Invalid email format. Must contain '@' and a valid domain.");
        }
    }

    public static void validatePhone(String phone) throws PhoneValidationException {
        phone = sanitize(phone);
        String phoneRegex = "^[6-9]\\d{9}$";
        if (!phone.matches(phoneRegex)) {
            throw new PhoneValidationException("Phone number must be exactly 10 digits and start with 6, 7, 8, or 9.");
        }
    }

    public static void validatePassword(String password) throws PasswordValidationException {
        password = sanitize(password);
        // Requires at least 8 chars, 1 uppercase, 1 lowercase, 1 number, 1 special character
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        if (!password.matches(passwordRegex)) {
            throw new PasswordValidationException("Password too weak! Must be 8+ characters, include an uppercase letter, a number, and a special character.");
        }
    }

    public static void validateEmployeeId(String empId) throws EmployeeIdValidationException {
        empId = sanitize(empId);
        String empIdRegex = "^EMP-\\d{4}$";
        if (!empId.matches(empIdRegex)) {
            throw new EmployeeIdValidationException("Employee ID must follow the exact pattern 'EMP-XXXX' (e.g., EMP-0001).");
        }
    }
}
