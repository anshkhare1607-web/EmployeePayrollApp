package com.dashboard;
import java.util.ArrayList;
import com.userregistration.*;
import com.payroll.*;


//Interface for the different dashBoards
public interface DashBoard {

	void display(ArrayList<PaySlip> paySlips, Employee employee);
}
