package com.authentication;

public class Session {
	private String username;
	private String role;
	private long loginTime; 
	private long timeoutMills;
	
	public Session(String username,String role) {
		this.username = username;
		this.role = role;
		this.loginTime = System.currentTimeMillis();
		this.timeoutMills = 300000 ;// 5 minute time out.
	}
	
	public String getRole() {
		return role; 
	}
	
	public boolean isExpired() {
		return (System.currentTimeMillis()-loginTime)>timeoutMills;
	}
	
	//Override
	public String toString() {
		return "Session active for user : "+username; 
	}

}
