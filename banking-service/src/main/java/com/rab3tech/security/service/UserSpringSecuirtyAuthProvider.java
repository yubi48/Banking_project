package com.rab3tech.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.customer.service.LoginService;
import com.rab3tech.vo.LoginVO;

/**
 * A custom service for retrieving users from a custom datasource, such as a database.
 * <p>
 * This custom service must implement Spring's {@link UserDetailsService}
 */
@Transactional(readOnly = true)
@Service("UserSpringSecuirtyAuthProvider")
public class UserSpringSecuirtyAuthProvider implements UserDetailsService {
	
	@Autowired
	public LoginService  loginService;
	
	/**
	 * Retrieves a user record containing the user's credentials and access. 
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// Declare a null Spring User
		UserDetails user = null;
		try {
			//us
			Optional<LoginVO> ouserSessionVO=loginService.findUserByUsername(username);
			if(ouserSessionVO.isPresent()) {
				LoginVO userSessionVO=ouserSessionVO.get();
				if(userSessionVO!=null && userSessionVO.getUsername()!=null) {
					//this is code which  is connecting our code to the spring security code	
						if(userSessionVO.getLocked()!=null && userSessionVO.getLocked().equalsIgnoreCase("yes")){
							 user =  new User(username, userSessionVO.getPassword(),	true,true,true,false,
										getAuthorities(userSessionVO.getRoles()));
						}else{
							user =  new User(userSessionVO.getUsername(), userSessionVO.getPassword(),	true,true,true,true,
									getAuthorities(userSessionVO.getRoles()));
						}
					}else{
						UsernameNotFoundException ex=new UsernameNotFoundException("Sorry user is not in database");
						throw ex;
					}
			}else {
				UsernameNotFoundException ex=new UsernameNotFoundException("Sorry user is not in database");
				throw ex;
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}
	
	/**
	 * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	 * Basically, this interprets the access value whether it's for a regular user or admin.
	 * 
	 * @param access an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	 public Collection<GrantedAuthority> getAuthorities(List<String> roles) {
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
			for(String prole:roles)
			authList.add(new SimpleGrantedAuthority(prole));
			return authList;
	  }
}
