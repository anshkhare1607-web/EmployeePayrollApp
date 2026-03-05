package com.payroll;

import com.userregistration.Employee;
import java.util.Scanner;

public class PayRollService {
    
    public PaySlip generatePayslip(Employee employee, String month, double basic, double hra, double da, double allowances) {
        SalaryComponents sc = new SalaryComponents(basic, hra, da, allowances);

        // Gross Salary Calculation
        double gross = basic + hra + da + allowances; 

        //Deductions 
        sc.pf = basic * 0.12;     // Provident Fund (12%)
        sc.tax = gross * 0.10;    // Income Tax (10%)

        //Net Pay
        sc.netPay = gross - (sc.pf + sc.tax);

        return new PaySlip(employee, sc, month);
    }

    public void runPayslipFlow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== PAYSLIP GENERATION ===");

        try {
            System.out.print("Enter Employee ID: ");
            String empId = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Month (e.g., January 2026): ");
            String month = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double basic = Double.parseDouble(sc.nextLine());

            System.out.print("Enter HRA: ");
            double hra = Double.parseDouble(sc.nextLine());

            System.out.print("Enter DA: ");
            double da = Double.parseDouble(sc.nextLine());

            System.out.print("Enter Allowances: ");
            double allowances = Double.parseDouble(sc.nextLine());

            // Temporary Employee object created for Payslip Aggregation logic
            Employee dummyEmp = new Employee(empId, name, "", "", null);

            PaySlip payslip = generatePayslip(dummyEmp, month, basic, hra, da, allowances);
            System.out.println(payslip);

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Please try again.");
        }
    }
}
