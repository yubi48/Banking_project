package com.rab3tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payee_account_status")
public class PayeeStatus {

	
	private int id;
	private String code;
	private String name;
	
	
	public PayeeStatus() {
		
	}
	
	public PayeeStatus(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=45)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PayeeStatus [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
	
}
