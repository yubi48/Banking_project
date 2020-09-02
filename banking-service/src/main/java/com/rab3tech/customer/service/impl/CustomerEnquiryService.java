package com.rab3tech.customer.service.impl;

import java.util.List;
import java.util.Optional;

import com.rab3tech.vo.CustomerSavingVO;

public interface CustomerEnquiryService {
	public CustomerSavingVO save(CustomerSavingVO customerSavingVO);
	List<CustomerSavingVO> findAll();
	CustomerSavingVO findById(int csaid);
	void deleteById(int csaid);
	boolean emailNotExist(String email);
	CustomerSavingVO changeEnquiryStatus(int csaid, String status);
	String updateEnquiryRegId(int csaid, String ucrid);
	Optional<CustomerSavingVO> findCustomerEnquiryByUuid(String ucrid);
	List<CustomerSavingVO> findPendingEnquiry();
	List<CustomerSavingVO> findRegisteredEnquiry();
	CustomerSavingVO findAppStatus(String searchText);
}
