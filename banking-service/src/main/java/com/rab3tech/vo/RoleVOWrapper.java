package com.rab3tech.vo;

import java.util.List;

public class RoleVOWrapper {
	
	List<RoleVO> roleVOs;
	List<Integer> currentRoles;
	
	public List<RoleVO> getRoleVOs() {
		return roleVOs;
	}
	public void setRoleVOs(List<RoleVO> roleVOs) {
		this.roleVOs = roleVOs;
	}
	public List<Integer> getCurrentRoles() {
		return currentRoles;
	}
	public void setCurrentRoles(List<Integer> currentRoles) {
		this.currentRoles = currentRoles;
	}
 	
}
