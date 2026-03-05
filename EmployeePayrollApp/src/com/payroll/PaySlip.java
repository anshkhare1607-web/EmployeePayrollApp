package com.payroll;

import com.userregistration.Employee;

public class PaySlip implements Cloneable {
    
    private Employee employee;
    private SalaryComponents components;
    private String month;

    public PaySlip(Employee employee, SalaryComponents components, String month) {
        this.employee = employee;
        this.components = components;
        this.month = month;
    }

    public String getEmpId() {
        return employee.getEmpId();
    }
    public String getMonth() {
    	return month;
    }
    public double getNetPay() {
    	return components.netPay;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new PaySlip(this.employee, this.components, this.month);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        PaySlip payslip = (PaySlip) o;
        return employee.getEmpId().equals(payslip.employee.getEmpId()) && month.equals(payslip.month);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + employee.getEmpId().hashCode();
        result = 31 * result + month.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n=========== PAYSLIP ===========\n"
             + "Month           : " + month + "\n"
             + "Employee ID     : " + employee.getEmpId() + "\n"
             + "Employee Name   : " + employee.getName() + "\n\n"
             + "---- Earnings ----\n"
             + "Basic Salary    : " + components.basicSalary + "\n"
             + "HRA             : " + components.hra + "\n"
             + "DA              : " + components.da + "\n"
             + "Allowances      : " + components.allowances + "\n\n"
             + "---- Deductions ----\n"
             + "PF              : " + components.pf + "\n"
             + "Tax             : " + components.tax + "\n\n"
             + "Net Pay         : " + components.netPay + "\n"
             + "===============================\n";
    }
}