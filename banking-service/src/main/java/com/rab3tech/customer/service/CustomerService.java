package com.rab3tech.customer.service;

import java.util.List;
import java.util.Optional;

import com.rab3tech.dao.entity.PayeeInfo;
import com.rab3tech.vo.AccountTypeVO;
import com.rab3tech.vo.CustomerAccountInfoVO;
import com.rab3tech.vo.CustomerUpdateVO;
import com.rab3tech.vo.CustomerVO;
import com.rab3tech.vo.PayeeInfoVO;
import com.rab3tech.vo.RoleVO;

public interface CustomerService {

	CustomerVO createAccount(CustomerVO customerVO);

	CustomerAccountInfoVO createBankAccount(int csaid);

	List<CustomerVO> findCustomers();

	byte[] findPhotoByid(int cid);

	void updateProfile(CustomerUpdateVO customerVO);
	
	public List<RoleVO> getRoles();

	CustomerVO searchCustomer(String name);
	
	List<AccountTypeVO> findAccountTypes();

	String findCustomerByEmail(String email);

	String findCustomerByMobile(String mobile);

	void addPayee(PayeeInfoVO payeeInfoVO);

	List<PayeeInfoVO> pendingPayeeList();

	//List<PayeeInfoVO> registeredPayeeList();

	List<CustomerVO> searchCustomerInfo(String searchText);

	byte[] findImgae(String email);

	List<String> findAccountType();

	boolean getUrnNumber(int payeeID, int urnNum, String button);

	List<PayeeInfoVO> registeredPayeeList(String id);

	//void getUrnNumber(int id, int urnNum, String button);

	

}
