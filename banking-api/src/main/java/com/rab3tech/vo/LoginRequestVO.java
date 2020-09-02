package com.rab3tech.vo;

public class LoginRequestVO {
	private String  username;
	private String  password ;
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
	@Override
	public String toString() {
		return "LoginRequestVO [username=" + username + ", password=" + password + "]";
	}
	
}
