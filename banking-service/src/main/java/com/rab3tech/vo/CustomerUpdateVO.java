package com.rab3tech.vo;

import org.springframework.web.multipart.MultipartFile;

public class CustomerUpdateVO {

	private int cid;
	private String name;
	private String mobile;
	private MultipartFile photo;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CustomerUpdateVO [cid=" + cid + ", name=" + name + ", mobile=" + mobile + ", photo=" + photo + "]";
	}

	
}
