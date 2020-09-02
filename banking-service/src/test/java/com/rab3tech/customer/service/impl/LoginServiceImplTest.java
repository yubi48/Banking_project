package com.rab3tech.customer.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.dao.entity.Login;
import com.rab3tech.dao.entity.Role;
import com.rab3tech.vo.LoginVO;

//JUNIT RUNNER from JUNIT
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	
	@Mock
	private LoginRepository loginRepository;
	
	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	
	@Before
	public void init() {
		 MockitoAnnotations.initMocks(this); //Initializing mocking for each test cases
	}
	
 /*	@Override
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
	} */
	
	@Test
	public void testUpdatePassCodeWhenUsernameExist() {
		Login login=new Login();
		login.setEmail("nagen@gmail.com");
		login.setName("Mr. Mocha");
		login.setLoginid("owowo282");
		Optional<Login> ologin=Optional.of(login);
		//stubbing
		when(loginRepository.findByLoginid("nagen@gmail.com")).thenReturn(ologin);
		
		String result=loginServiceImpl.updatePassCode("nagen@gmail.com", "AX&#%^@S");
		assertEquals("Mr. Mocha", result);
	}
	
	
	@Test
	public void testUpdatePassCodeWhenUsernameNotExist() {

		Optional<Login> ologin=Optional.empty();
		when(loginRepository.findByLoginid("sweta@gmail.com")).thenReturn(ologin);
		
		String result=loginServiceImpl.updatePassCode("sweta@gmail.com", "AX&#%^@S");
		assertEquals("notexist", result);
		
	}
	

	@Test
	public void testFindUserByUsernameWhenExist() {
		
		Login login=new Login();
		login.setEmail("nagen@gmail.com");
		login.setName("Mr. Mocha");
		login.setLoginid("owowo282");
		login.setPassword("cool@1234");
		Set<Role> rolesSet=new HashSet<>();
		Role role=new Role();
		role.setName("ADMIN");
		role.setRid(100);
		rolesSet.add(role);
		login.setRoles(rolesSet);
		Optional<Login> ologin=Optional.of(login);
		
		//stubbing
		when(loginRepository.findByLoginid("nagen@gmail.com")).thenReturn(ologin);
		
		Optional<LoginVO>   optional=loginServiceImpl.findUserByUsername("nagen@gmail.com");
		
		assertTrue(optional.isPresent());
		assertEquals("nagen@gmail.com", optional.get().getEmail());
		assertEquals("owowo282", optional.get().getUsername());
	}
	
	@Test
	public void testFindUserByUsernameWhenNotExist() {
		
		Optional<Login> ologin=Optional.empty();
		when(loginRepository.findByLoginid("sweta@gmail.com")).thenReturn(ologin);
		
		Optional<LoginVO>   optional=loginServiceImpl.findUserByUsername("sweta@gmail.com");
		//assertTrue(optional.isEmpty());
	}

	@Test
	public void testAuthUserWhenExist() {
		Login login=new Login();
		login.setEmail("nagen@gmail.com");
		login.setLoginid("owowo282");
		login.setPassword("cool@1234");
		Set<Role> rolesSet=new HashSet<>();
		Role role=new Role();
		role.setName("ADMIN");
		role.setRid(100);
		rolesSet.add(role);
		login.setRoles(rolesSet);
		Optional<Login> ologin=Optional.of(login);
		
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername("nagen@gmail.com");
		loginVO.setPassword("cool@1234");
		when(loginRepository.findByLoginidAndPassword("nagen@gmail.com","cool@1234")).thenReturn(ologin);
		Optional<LoginVO> loginVO2=loginServiceImpl.authUser(loginVO);
		assertTrue(loginVO2.isPresent());
		assertEquals("cool@1234", loginVO2.get().getPassword());
		assertEquals("ADMIN", loginVO2.get().getRoles().get(0));
	}
	
	@Test
	public void testAuthUserWhenNotExist() {
		Optional<Login> ologin=Optional.empty();
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername("nagen@gmail.com");
		loginVO.setPassword("cool@1234");
		when(loginRepository.findByLoginidAndPassword("nagen@gmail.com","cool@1234")).thenReturn(ologin);
		Optional<LoginVO> loginVO2=loginServiceImpl.authUser(loginVO);
		assertFalse(loginVO2.isPresent());
	}

}
