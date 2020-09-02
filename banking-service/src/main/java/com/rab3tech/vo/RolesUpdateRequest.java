package com.rab3tech.vo;

import java.util.List;

public class RolesUpdateRequest {

	private int cid;
	private List<Integer> rolesid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public List<Integer> getRolesid() {
		return rolesid;
	}

	public void setRolesid(List<Integer> rolesid) {
		this.rolesid = rolesid;
	}

	@Override
	public String toString() {
		return "RolesUpdateRequest [cid=" + cid + ", rolesid=" + rolesid + "]";
	}

}
