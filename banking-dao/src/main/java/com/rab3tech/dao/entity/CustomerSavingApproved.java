package com.rab3tech.dao.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author nagendra
 *   
 */

@Entity
@Table(name="customer_saving_enquiry_approved_tbl")
public class CustomerSavingApproved {

	private int csaid;
	private String name;
	private String email;
	private String mobile;
	private String location;
	private String ucrid;
	private AccountType accType;
	private AccountStatus status;
	private Date doa;
	private String appref;
	
	
	public CustomerSavingApproved() {}
	
	
	public CustomerSavingApproved(int csaid, String name, String email, String mobile, String location, String ucrid,
			AccountType accType, AccountStatus status, Date doa, String appref) {
		super();
		this.csaid = csaid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.location = location;
		this.ucrid = ucrid;
		this.accType = accType;
		this.status = status;
		this.doa = doa;
		this.appref = appref;
	}

	@Column(length=30)
	public String getAppref() {
		return appref;
	}

	public void setAppref(String appref) {
		this.appref = appref;
	}

	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status", nullable = false)
	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCsaid() {
		return csaid;
	}

	public void setCsaid(int csaid) {
		this.csaid = csaid;
	}

	@Column(length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=15)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(length=100)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDoa() {
		return doa;
	}

	public void setDoa(Date doa) {
		this.doa = doa;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accType", nullable = false)
	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	@Column(length=100)
	public String getUcrid() {
		return ucrid;
	}

	public void setUcrid(String ucrid) {
		this.ucrid = ucrid;
	}
	
}

