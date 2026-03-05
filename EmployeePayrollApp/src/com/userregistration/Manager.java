package com.userregistration;
import com.authentication.*;

//manager class
public class Manager extends User {

	public Manager(String username,String password) {
		super(username,password,"MANAGER"); //calling user class for user creation.
	}
	
	//Override
	public boolean authenticate(String username, String password) {
		return this.username.equals(username) && this.passwordHash.equals(PasswordUtil.hash(password)); 
	}
}
