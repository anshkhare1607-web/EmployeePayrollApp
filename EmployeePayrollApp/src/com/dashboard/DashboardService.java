package com.dashboard;

import java.util.ArrayList;
import java.util.Scanner;
import com.userregistration.*;
import com.payroll.*;
import com.payroll.*;

//DashBoard service

public class DashboardService {
    
    public void runDashboardFlow(Scanner scanner) {
        System.out.println("\n=== DASHBOARD DISPLAY ===");
        
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();
            
            System.out.print("Enter Employee Name: ");
            String empName = scanner.nextLine();
            
            System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
            String role = scanner.nextLine().toUpperCase();
            
            Employee dummyEmp = new Employee(empId, empName, "", "", null);
            
            System.out.print("How many payslip records to enter? ");
            int numRecords = scanner.nextInt();
            
            ArrayList<PaySlip> payslips = new ArrayList<>();
            for (int i = 0; i < numRecords; i++) {
                System.out.println("\nRecord " + (i + 1) + ":");
                System.out.print("Enter Month (e.g., May): ");
                String month = scanner.nextLine();
                
                System.out.print("Enter Net Pay: ");
                double netPay = scanner.nextDouble(); 
                
                SalaryComponents sc = new SalaryComponents(0, 0, 0, 0);
                sc.netPay = netPay;
                payslips.add(new PaySlip(dummyEmp, sc, month));
            }
             
            DashBoard dashboard = DashboardFactory.getDashboard(role);
            
            if (dashboard != null) { 
                dashboard.display(payslips, dummyEmp);
            } else {
                System.out.println("\nError: Invalid role specified.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("\nError: Invalid numeric input.");
        } catch (Exception e) {
            System.out.println("\nError during dashboard generation: " + e.getMessage());
        }
    }
}