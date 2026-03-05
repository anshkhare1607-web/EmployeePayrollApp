package com.payroll;

//Storing salary components
public class SalaryComponents {
	double basicSalary;
	double hra;
	double da;
	double allowances;
	double pf;
	double tax;
	double netPay;
	
	public SalaryComponents(double basicSalary ,double hra,double da,double allowances) {
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.pf = pf;
		this.allowances = allowances;
	}

}
