package com.payroll;

import java.util.Scanner;
import com.userregistration.Employee;

public class PaySlipDownloadService {

    public void runDownloadFlow(Scanner scanner) {
        System.out.println("\n=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String empName = scanner.nextLine();

            System.out.print("Enter Month (e.g., January 2026): ");
            String month = scanner.nextLine();

            System.out.print("Enter Net Pay: ");
            double netPay = Double.parseDouble(scanner.nextLine());

            Employee dummyEmp = new Employee(empId, empName, "", "", null);
            SalaryComponents sc = new SalaryComponents(0, 0, 0, 0);
            sc.netPay = netPay;

            PaySlip original = new PaySlip(dummyEmp, sc, month);

            System.out.println("\nOriginal Payslip Loaded:");
            System.out.println(original);

            DownloadToken token = new DownloadToken();

            if (!token.isExpired()) { 
                
                PaySlip copy = (PaySlip) original.clone();
                
                if (original.equals(copy)) {
                    System.out.println("[System: Validation successful. Object safely cloned.]");
                }

                FileService fileService = new FileService();

                System.out.println("\nSelect Download Format:");
                System.out.println("1. TXT File");
                System.out.println("2. PDF File");
                System.out.print("Enter choice (1 or 2): ");
                String formatChoice = scanner.nextLine().trim();

                String savedFileName;
                if (formatChoice.equals("2")) {
                    savedFileName = fileService.savePayslipAsPdf(copy);
                } else {
                    savedFileName = fileService.savePayslipAsText(copy); 
                }

                System.out.println("\nSuccess! Payslip downloaded securely.");
                System.out.println("Saved as: " + savedFileName);

            } else {
                System.out.println("\nError: Download session expired.");
            }

        } catch (NumberFormatException e) {
            System.out.println("\nError: Invalid numeric input for Net Pay.");
        } catch (Exception e) {
            System.out.println("\nError during payslip download: " + e.getMessage());
        }
    }
}