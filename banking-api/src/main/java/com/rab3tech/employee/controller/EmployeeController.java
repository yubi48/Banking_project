package com.rab3tech.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.email.service.EmailService;
import com.rab3tech.utils.BankHttpUtils;
import com.rab3tech.vo.ApplicationResponseVO;
import com.rab3tech.vo.CustomerSavingVO;
import com.rab3tech.vo.EmailVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
public class EmployeeController {
	

	@Autowired
	private CustomerEnquiryService customerEnquiryService;
	
	@Autowired
	private EmailService emailService;
	
	@Value("${customer.registration.url}")
	private String registrationURL;
	
	@PostMapping("/customers/enquiry/approve")
	public ApplicationResponseVO customerEnquiryApprove(@RequestParam int csaid,HttpServletRequest request) {
		CustomerSavingVO customerSavingVO=customerEnquiryService.changeEnquiryStatus(csaid, "APPROVED");
		String cuuid=BankHttpUtils.generateToken();
		customerEnquiryService.updateEnquiryRegId(csaid, cuuid);
		String registrationLink=BankHttpUtils.getServerBaseURL(request)+"/"+registrationURL+cuuid;
		//String registrationLink ="http://localhost:8080/v3/customer/registration/complete";
		EmailVO mail=new EmailVO(customerSavingVO.getEmail(),"javahunk2020@gmail.com","Regarding Customer "+customerSavingVO.getName()+"  Account registration","",customerSavingVO.getName());
		mail.setRegistrationlink(registrationLink);
		emailService.sendRegistrationEmail(mail);
		//sendRegistrationEmail
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Hi your registration link has been sent to your at email "+customerSavingVO.getEmail());
		return applicationResponseVO;
	}

}
