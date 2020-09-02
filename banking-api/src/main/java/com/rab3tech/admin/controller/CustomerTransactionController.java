package com.rab3tech.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.vo.CustomerVO;

@RestController
//@RequestMapping("/admin")
public class CustomerTransactionController {
	
	@Autowired
	private CustomerService customerService;

	//@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

/*	@RequestMapping("/customer/{id}")
	public CustomerTransactionDTO hi(@PathVariable String id) {
		CustomerTransactionDTO customerTransactionDTO = this.restTemplate.getForObject("http://transaction-services/customer/transaction/"+id, CustomerTransactionDTO.class);
		return customerTransactionDTO;
	}*/
	
	@GetMapping("/v4/customers")
	public List<CustomerVO> findCustomers(){
		return customerService.findCustomers();
	}
}
