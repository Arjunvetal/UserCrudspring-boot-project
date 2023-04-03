package com.arjun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class UserLogin {

	
	private String username;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
