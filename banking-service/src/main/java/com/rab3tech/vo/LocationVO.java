package com.rab3tech.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LocationVO {
	private int id;
	private String lcode;
	private String name;
	private Timestamp doe;
	private Timestamp dom;
	private LoginVO login;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDoe() {
		return doe;
	}
	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	public Timestamp getDom() {
		return dom;
	}
	public void setDom(Timestamp dom) {
		this.dom = dom;
	}
	public LoginVO getLogin() {
		return login;
	}
	public void setLogin(LoginVO login) {
		this.login = login;
	}
	
	
}
