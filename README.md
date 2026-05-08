
# Employee Payroll Management System

## Description

The Employee Payroll Management System is a Java-based console application designed to manage employee registration, authentication, payroll processing, and payslip management. The system supports role-based access for employees and managers, with comprehensive input validation and secure data handling.


## Features

- **User Registration**: Register new employees with validated input fields including employee ID, name, email, phone, and password
- **Authentication**: Secure login system with password hashing and session management
- **Payslip Generation**: Calculate and generate payslips with salary components (basic, HRA, DA, allowances, deductions)
- **Payslip Download**: Secure download functionality supporting TXT and PDF formats with data integrity protection
- **Analytics Dashboard**: Role-based dashboards displaying payslip analytics for employees and managers
- **Input Validation**: Comprehensive validation for email, phone, password, and employee ID formats
- **Data Persistence**: File-based storage for employee records

## Use Cases

1. **Employee Registration**: Register new employees with validated information
2. **User Authentication**: Login with username and password
3. **Payslip Generation**: Generate payslips with salary calculations
4. **Payslip Download**: Download payslips in multiple formats with security measures
5. **Dashboard Analytics**: View personalized analytics based on user role

## Technologies Used

- **Language**: Java
- **Architecture**: Object-oriented design with packages for modularity
- **Security**: Password hashing, session management, input sanitization
- **File I/O**: Text file persistence for employee data
- **Design Patterns**: Factory pattern for dashboard creation, Strategy pattern for user authentication

## Project Structure

```
src/
├── com/
│   ├── authentication/     # Authentication and session management
│   ├── dashboard/          # Dashboard services and role-based displays
│   ├── exceptionhandling/  # Custom exceptions and validation services
│   ├── main/               # Application entry point
│   ├── payroll/            # Payroll calculation and payslip services
│   ├── ui/                 # User interface and menu controller
│   ├── userregistration/   # User models and registration services
│   └── validatorclass/     # Validation utilities
```



