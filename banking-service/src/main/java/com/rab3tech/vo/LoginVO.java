package com.rab3tech.vo;

import java.sql.Timestamp;
import java.util.List;

public class LoginVO {

	private int uid;
	private String username;
	private String password;
	private Timestamp llt;
	private String email;
	private List<String> roles;
	private String name;
	private String salutation;
	private String locked;
	
	public Timestamp getLlt() {
		return llt;
	}

	public void setLlt(Timestamp llt) {
		this.llt = llt;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Override
	public String toString() {
		return "LoginVO [uid=" + uid + ", username=" + username + ", email=" + email + ", roles=" + roles + ", name="
				+ name + ", salutation=" + salutation + "]";
	}

}
