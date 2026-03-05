package com.dashboard;
//DashBoard Factory

public class DashboardFactory {
    public static DashBoard getDashboard(String role) {
        if ("EMPLOYEE".equalsIgnoreCase(role)) {
            return new EmployeeDashBoard();
        } else if ("MANAGER".equalsIgnoreCase(role)) {
            return new ManagerDashBoard();
        }
        return null;
    }
} 