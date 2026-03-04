package com.userregistration;

import java.io.*;

//Employee Class 
class Employee {
 private String empId;
 private String name;
 private String email;
 private String phone;
 private UserAccount account;

 public Employee(String empId, String name, String email, String phone, UserAccount account) {
     this.empId = empId;
     this.name = name;
     this.email = email;
     this.phone = phone;
     this.account = account;
 }

 public void persist() throws IOException {
     try (PrintWriter out = new PrintWriter(new FileWriter("employee_data.txt", true))) {
         out.println(this.toString());
         out.println("------------------------------");
     }
 }

 @Override
 public String toString() {
     return "Employee ID : " + empId + 
          "\nName        : " + name + 
          "\nEmail       : " + email + 
          "\nPhone       : " + phone + 
          "\n" + account.toString();
 }
}