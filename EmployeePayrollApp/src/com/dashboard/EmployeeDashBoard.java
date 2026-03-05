package com.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import com.userregistration.Employee;
import com.payroll.*;

public class EmployeeDashBoard implements DashBoard {

    //Override
    public void display(ArrayList<PaySlip> paySlips, Employee employee) {
        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());

        Collections.sort(paySlips, new Comparator<PaySlip>() {
            public int compare(PaySlip p1, PaySlip p2) {
                return (int)(p2.getNetPay() - p1.getNetPay()); 
            }
        });

        System.out.println("\nRecent Payslips (Top 3):");
        int count = 0;
        Iterator<PaySlip> it = paySlips.iterator();
        while (it.hasNext() && count < 3) {
            PaySlip p = it.next();
            System.out.println(p.getMonth() + " : " + p.getNetPay());
            count++;
        }

        double total = 0;
        Iterator<PaySlip> it2 = paySlips.iterator();
        while (it2.hasNext()) {
            PaySlip p = it2.next();
            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}