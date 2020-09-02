package com.rab3tech.customer.service;

import java.util.List;
import java.util.Optional;

import com.rab3tech.vo.ChangePasswordRequestVO;
import com.rab3tech.vo.ChangePasswordVO;
import com.rab3tech.vo.LoginVO;
import com.rab3tech.vo.RoleVO;
import com.rab3tech.vo.RolesUpdateRequest;

public interface LoginService {

	Optional<LoginVO> authUser(LoginVO loginVO);

	Optional<LoginVO> findUserByUsername(String loginid);

	void changePassword(ChangePasswordVO changePasswordVO);

	boolean checkPasswordValid(String username, String password);

	String updatePassCode(String emailOrUsername, String passCode);

	String updatePassword(ChangePasswordRequestVO changePasswordRequestVO);

	List<RoleVO> findRoles();
	
	List<RoleVO> findRolesByUserid(String userid);

	String updateCustomerRoles(RolesUpdateRequest rolesUpdateRequest);
	

}
