package com.payroll;
import com.userregistration.*;

public class PaySlip {
	private Employee employee; //aggregation
	private SalaryComponents components; //composition
	private String month;

	public PaySlip(Employee employee, SalaryComponents components, String month) {
		this.employee = employee;
		this.components = components;
		this.month = month;
	}

	//Override
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
