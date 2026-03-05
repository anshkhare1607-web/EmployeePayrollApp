package com.userregistration;

import com.authentication.*;

//UserAccount Class 
public abstract class User {
	protected String username;
	protected String passwordHash;
	protected String role;

	public User(String username, String passwordHash, String role) {
		this.username = username;
		this.passwordHash = PasswordUtil.hash(passwordHash);
		this.role = role;
	} 
	
	//abstract method
	public abstract boolean authenticate(String username, String password);
	
	public String getRole() {
		return role;
	}
}