package com.userregistration;

public class UserAccount {

	private String username;
	private String password;
	
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Override
	public String toString() {
		return "Username :" + username;
	}
	
}

