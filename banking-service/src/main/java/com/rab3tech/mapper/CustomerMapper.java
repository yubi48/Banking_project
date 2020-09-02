package com.rab3tech.mapper;

import com.rab3tech.dao.entity.Customer;
import com.rab3tech.vo.CustomerVO;

public class CustomerMapper {
	
	public static CustomerVO toVO(Customer customer) {
		CustomerVO customerVO=new CustomerVO();
		customerVO.setUserid(customer.getLogin().getLoginid());
		customerVO.setAddress(customer.getAddress());
		customerVO.setEmail(customer.getEmail());
		customerVO.setGender(customer.getGender());
		customerVO.setMobile(customer.getMobile());
		customerVO.setName(customer.getName());
		customerVO.setSsn(customer.getSsn());
		customerVO.setId(customer.getId());
		return customerVO;
	}

}
