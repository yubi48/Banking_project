package com.rab3tech.customer.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.admin.dao.repository.MagicCustomerRepository;
import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.customer.dao.repository.RoleRepository;
import com.rab3tech.customer.service.LoginService;
import com.rab3tech.dao.entity.Customer;
import com.rab3tech.dao.entity.Login;
import com.rab3tech.dao.entity.Role;
import com.rab3tech.vo.ChangePasswordRequestVO;
import com.rab3tech.vo.ChangePasswordVO;
import com.rab3tech.vo.LoginVO;
import com.rab3tech.vo.RoleVO;
import com.rab3tech.vo.RolesUpdateRequest;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	
	@Autowired
	private MagicCustomerRepository customerRepository;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public boolean checkPasswordValid(String username,String password) {
		Login  login=loginRepository.findByLoginid(username).get();
		if(bCryptPasswordEncoder.matches(password, login.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public void changePassword(ChangePasswordVO changePasswordVO) {
		String encodedPassword=bCryptPasswordEncoder.encode(changePasswordVO.getNewPassword());
		Login  login=loginRepository.findByLoginid(changePasswordVO.getLoginid()).get();
		login.setPassword(encodedPassword);
		login.setLlt(new Timestamp(new Date().getTime()));
		//loginRepository.save(login);
	}
	
	@Override
	public Optional<LoginVO> findUserByUsername(String loginid) {
		LoginVO loginVO =new LoginVO();
		loginVO.setUsername(loginid);
		Optional<Login>  optional=loginRepository.findByLoginid(loginid);
		if(optional.isPresent()) {
			Login login=optional.get();
			loginVO.setEmail(login.getEmail());
			loginVO.setUsername(login.getLoginid());
			loginVO.setPassword(login.getPassword());
			loginVO.setLlt(login.getLlt());
			Set<Role> rolesSet=login.getRoles();
			List<String> roleList=new ArrayList<>();
			//List<String> roles= rolesSet.stream().map(Role::getName).collect(Collectors.toList());
			for(Role role:rolesSet) {
				roleList.add(role.getName());
			}
			loginVO.setRoles(roleList);
			return Optional.of(loginVO);
		}else {
			return Optional.empty();
		}
	}
	
	@Override
	public String updatePassword(ChangePasswordRequestVO changePasswordRequestVO) {
		Optional<Login>  optional=loginRepository.findByLoginidAndToken(changePasswordRequestVO.getLoginid(), changePasswordRequestVO.getPasscode());
		if(optional.isPresent()) {
			Login login=optional.get();
			login.setToken("");
			login.setLwap(null);
			String encodedPassword=bCryptPasswordEncoder.encode(changePasswordRequestVO.getNewpassword());
			login.setPassword(encodedPassword);
			return "success";
		}else {
			return "Sorry, ! your passcode is not correct!";	
		}
	}
	
	@Override
	public String updatePassCode(String emailOrUsername,String passCode) {
		String status="notexist";
		Optional<Login> optional=loginRepository.findByLoginid(emailOrUsername);
		if(optional.isPresent()) {
			//I am loading 
			Login login=optional.get();	
			login.setToken(passCode);
			//at what time this passcode was updated
			login.setLwap(new Timestamp(new Date().getTime()));
			status=login.getName();
		}
		return status;
	}
	
	@Override
	public Optional<LoginVO> authUser(LoginVO loginVO) {
		Optional<Login>  optional=loginRepository.findByLoginidAndPassword(loginVO.getUsername(), loginVO.getPassword());
		if(optional.isPresent()) {
			Login login=optional.get();
			loginVO.setEmail(login.getEmail());
			Set<Role> rolesSet=login.getRoles();
			List<String> roleList=new ArrayList<>();
			//List<String> roles= rolesSet.stream().map(Role::getName).collect(Collectors.toList());
			for(Role role:rolesSet) {
				roleList.add(role.getName());
			}
			loginVO.setRoles(roleList);
			return Optional.of(loginVO);
		}else {
			return Optional.empty();
		}
	}
	
	@Override
	public List<RoleVO> findRoles(){
		List<Role> roles=roleRepository.findAll();
		return roles.stream().map(t->{
			RoleVO roleVO=new RoleVO();
			BeanUtils.copyProperties(t, roleVO);
			roleVO.setId(t.getRid());
			return roleVO;
		}).collect(Collectors.toList());
	}
	
	@Override
	public String updateCustomerRoles(RolesUpdateRequest rolesUpdateRequest){
		Customer customer=customerRepository.findById(rolesUpdateRequest.getCid()).get();
		Login login=customer.getLogin();
		Set<Role> roles=new HashSet<Role>();
        for(Integer rid:rolesUpdateRequest.getRolesid()) {
        	Role role=roleRepository.findById(rid).get();
        	roles.add(role);
        }
        login.setRoles(roles);
		return "updated";
	}



	@Override
	public List<RoleVO> findRolesByUserid(String userid) {
		Login login=loginRepository.findByLoginid(userid).get();
		Set<Role> roles=login.getRoles();
		
		return roles.stream().map(t->{
			RoleVO roleVO=new RoleVO();
			BeanUtils.copyProperties(t, roleVO);
			roleVO.setId(t.getRid());
			return roleVO;
		}).collect(Collectors.toList());
	}
}
