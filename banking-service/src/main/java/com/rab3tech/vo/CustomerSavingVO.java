package com.rab3tech.vo;


import java.util.Date;

/**
 * 
 * @author nagendra
 *   
 */

public class CustomerSavingVO {

	private int csaid;
	private String name;
	private String email;
	private String mobile;
	private String location;
	private String accType;
	private String status;
	private String ucrid;
	private Date doa;
	private String appref;
	
	public CustomerSavingVO() {}
	
	public CustomerSavingVO(int csaid, String name, String email, String mobile, String location, String accType,
			String status, String ucrid, Date doa, String appref) {
		this.csaid = csaid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.location = location;
		this.accType = accType;
		this.status = status;
		this.ucrid = ucrid;
		this.doa = doa;
		this.appref = appref;
	}

	public String getUcrid() {
		return ucrid;
	}

	public void setUcrid(String ucrid) {
		this.ucrid = ucrid;
	}

	public String getAppref() {
		return appref;
	}

	public void setAppref(String appref) {
		this.appref = appref;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCsaid() {
		return csaid;
	}

	public void setCsaid(int csaid) {
		this.csaid = csaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerSavingVO other = (CustomerSavingVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}

