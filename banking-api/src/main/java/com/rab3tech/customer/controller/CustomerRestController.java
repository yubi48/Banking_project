package com.rab3tech.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.LoginService;
import com.rab3tech.utils.PasswordGenerator;
import com.rab3tech.vo.ApplicationResponseVO;
import com.rab3tech.vo.ChangePasswordRequestVO;
import com.rab3tech.vo.LoginRequestVO;
import com.rab3tech.vo.LoginVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
public class CustomerRestController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	//{   "loginid":"nagen@gmail.com",
	 //      "passcode":"2938939",
	  //      "newpassword":"*(#$*$*$*$$&"
	//
     // } @RequestBody // it takes JSON data from request body and converts into Java Object
	@PostMapping("/customer/change/password")
	public ApplicationResponseVO updateCustomerPassword(@RequestBody ChangePasswordRequestVO changePasswordRequestVO) {

		String status=loginService.updatePassword(changePasswordRequestVO);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		if("success".equalsIgnoreCase(status)) {
			applicationResponseVO.setCode(200);
			applicationResponseVO.setStatus("success");
			applicationResponseVO.setMessage("Your password is updated successfully.");
			return applicationResponseVO;
		}else {
			applicationResponseVO.setCode(0);
			applicationResponseVO.setStatus("fail");
			applicationResponseVO.setMessage(status);
			return applicationResponseVO;
		}
	}
	
	
	@GetMapping("/customer/passcode")
	// var promise= fetch("v3/customer/passcode?usernameOrEmail="+usernameEmail); 	
	public ApplicationResponseVO sendPassCode(@RequestParam("usernameOrEmail") 
	String usernameOrEmail) {
		String email=usernameOrEmail;
		
		String passCode=PasswordGenerator.generateRandomPassword(8);
		String result=loginService.updatePassCode(email,passCode);
		if("notexist".equalsIgnoreCase(result)) {
			ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
			applicationResponseVO.setCode(0);
			applicationResponseVO.setStatus("fail");
			applicationResponseVO.setMessage("Sorry, this username or email does not exist , "+email);
			return applicationResponseVO;
		}
		try {
			 //below line will send the email
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
	         mailMessage.setTo(email);
		     mailMessage.setSubject("Regarding your passcode to change password");
	         mailMessage.setText("Hey! "+result+" ,   your password code is  = "+passCode);
		     mailMessage.setFrom("javahunk100@gmail.com");
	         javaMailSender.send(mailMessage);
	         
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Your passcode is  = "+passCode);
		}
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setStatus("success");
		applicationResponseVO.setMessage("Passcode has been sent on your email "+email);
		return applicationResponseVO;
	}
	
	
	@PostMapping("/user/login")
	public ApplicationResponseVO authUser(@RequestBody LoginRequestVO loginRequestVO) {
		Optional<LoginVO>  optional=loginService.findUserByUsername(loginRequestVO.getUsername());
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		if(optional.isPresent()) {
			applicationResponseVO.setCode(200);
			applicationResponseVO.setStatus("success");
			applicationResponseVO.setMessage("Userid is correct");
		}else {
			applicationResponseVO.setCode(400);
			applicationResponseVO.setStatus("fail");
			applicationResponseVO.setMessage("Userid is not correct");
		}
		return applicationResponseVO;
	}
}
