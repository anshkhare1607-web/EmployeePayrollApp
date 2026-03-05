package com.authentication;

public class Session {
	private String username;
	private long loginTime; 
	private long timeoutMills;
	
	public Session(String username) {
		this.username = username;
		this.loginTime = System.currentTimeMillis();
		this.timeoutMills = 300000 ;// 5 minute time out.
	}
	
	public boolean isExpired() {
		return (System.currentTimeMillis()-loginTime)>timeoutMills;
	}
	
	//Override
	public String toString() {
		return "Session active for user : "+username; 
	}

}
