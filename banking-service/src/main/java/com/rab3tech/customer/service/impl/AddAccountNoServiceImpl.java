package com.rab3tech.customer.service.impl;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.customer.dao.repository.CustomerAccountEnquiryRepository;
import com.rab3tech.customer.dao.repository.CustomerAccountInfoRepository;
import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.dao.entity.CustomerAccountInfo;
import com.rab3tech.dao.entity.CustomerSaving;
import com.rab3tech.utils.Utils;
import com.rab3tech.vo.CustomerVO;

@Service
@Transactional
public class AddAccountNoServiceImpl implements AddAccountNo {
	
	@Autowired
	private CustomerAccountEnquiryRepository customerAccEnqRepo;
	
	@Autowired
	private CustomerAccountInfoRepository customerAccInfoEnqRepo;
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public void createAccountNo(CustomerVO customerVO) {
		
		CustomerAccountInfo customerAccountInfo = new CustomerAccountInfo();
	
		CustomerSaving customer = customerAccEnqRepo.findByEmail(customerVO.getEmail()).get();
		String accountNumber = Utils.generateCustomerAccount();
		customerAccountInfo.setAccountNumber(accountNumber);
		customerAccountInfo.setCurrency("USD");
		customerAccountInfo.setBranch(customer.getLocation());
		customerAccountInfo.setCustomerId(loginRepo.findById(customerVO.getEmail()).get());
		customerAccountInfo.setTavBalance(0f);
		customerAccountInfo.setAvBalance(1000f);
		customerAccountInfo.setStatusAsOf(new Date(0));
		customerAccountInfo.setAccountType(customer.getAccType());
		customerAccInfoEnqRepo.save(customerAccountInfo);
		System.out.println(accountNumber);
		 
	}
	
}
