
package com.dashboard;

import java.util.ArrayList;
import java.util.Iterator;
import com.userregistration.Employee;
import com.payroll.*;

public class ManagerDashBoard implements DashBoard {

    //Override
    public void display(ArrayList<PaySlip> paySlips, Employee employee) { 
        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());

        double total = 0;
        Iterator<PaySlip> it = paySlips.iterator();
        while (it.hasNext()) {
            PaySlip p = it.next();
            total += p.getNetPay();
        }

        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}
