package com.authentication;

//password conversion to hashcode
public class PasswordUtil {
	
	public static String hash(String password) {
		//simple mock hashing
		return Integer.toHexString(password.hashCode());
	}

}
