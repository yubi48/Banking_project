package com.rab3tech.customer.service.impl;

import java.io.IOException;
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

import com.rab3tech.admin.dao.repository.AccountStatusRepository;
import com.rab3tech.admin.dao.repository.AccountTypeRepository;
import com.rab3tech.admin.dao.repository.MagicCustomerRepository;
import com.rab3tech.customer.dao.repository.CustomerAccountApprovedRepository;
import com.rab3tech.customer.dao.repository.CustomerAccountEnquiryRepository;
import com.rab3tech.customer.dao.repository.CustomerAccountInfoRepository;
import com.rab3tech.customer.dao.repository.CustomerRepository;
import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.customer.dao.repository.PayeeRepository;
import com.rab3tech.customer.dao.repository.RoleRepository;
import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.dao.entity.AccountStatus;
import com.rab3tech.dao.entity.AccountType;
import com.rab3tech.dao.entity.Customer;
import com.rab3tech.dao.entity.CustomerAccountInfo;
import com.rab3tech.dao.entity.CustomerSaving;
import com.rab3tech.dao.entity.CustomerSavingApproved;
import com.rab3tech.dao.entity.Login;
import com.rab3tech.dao.entity.PayeeInfo;
import com.rab3tech.dao.entity.PayeeStatus;
import com.rab3tech.dao.entity.Role;
import com.rab3tech.mapper.CustomerMapper;
import com.rab3tech.utils.AccountStatusEnum;
import com.rab3tech.utils.PasswordGenerator;
import com.rab3tech.utils.Utils;
import com.rab3tech.vo.AccountTypeVO;
import com.rab3tech.vo.CustomerAccountInfoVO;
import com.rab3tech.vo.CustomerUpdateVO;
import com.rab3tech.vo.CustomerVO;
import com.rab3tech.vo.LoginVO;
import com.rab3tech.vo.PayeeInfoVO;
import com.rab3tech.vo.RoleVO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private MagicCustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AccountStatusRepository accountStatusRepository;

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustomerAccountEnquiryRepository customerAccountEnquiryRepository;

	@Autowired
	private CustomerAccountApprovedRepository customerAccountApprovedRepository;

	@Autowired
	private CustomerAccountInfoRepository customerAccountInfoRepository;

	@Autowired
	private CustomerRepository CustomerRepository;

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private LoginRepository loginRepo;
	
	@Override
	public CustomerAccountInfoVO createBankAccount(int csaid) {
		// logic
		String customerAccount = Utils.generateCustomerAccount();
		CustomerSaving customerSaving = customerAccountEnquiryRepository.findById(csaid).get();

		CustomerAccountInfo customerAccountInfo = new CustomerAccountInfo();
		customerAccountInfo.setAccountNumber(customerAccount);
		customerAccountInfo.setAccountType(customerSaving.getAccType());
		customerAccountInfo.setAvBalance(1000.0F);
		customerAccountInfo.setBranch(customerSaving.getLocation());
		customerAccountInfo.setCurrency("$");
		Customer customer = customerRepository.findByEmail(customerSaving.getEmail()).get();
		customerAccountInfo.setCustomerId(customer.getLogin());
		customerAccountInfo.setStatusAsOf(new Date());
		customerAccountInfo.setTavBalance(1000.0F);
		CustomerAccountInfo customerAccountInfo2 = customerAccountInfoRepository.save(customerAccountInfo);

		CustomerSavingApproved customerSavingApproved = new CustomerSavingApproved();
		BeanUtils.copyProperties(customerSaving, customerSavingApproved);
		customerSavingApproved.setAccType(customerSaving.getAccType());
		customerSavingApproved.setStatus(customerSaving.getStatus());
		// saving entity into customer_saving_enquiry_approved_tbl
		customerAccountApprovedRepository.save(customerSavingApproved);

		// delete data from
		customerAccountEnquiryRepository.delete(customerSaving);

		CustomerAccountInfoVO accountInfoVO = new CustomerAccountInfoVO();
		BeanUtils.copyProperties(customerAccountInfo2, accountInfoVO);
		return accountInfoVO;

	}

	@Override
	public CustomerVO createAccount(CustomerVO customerVO) {
		Customer pcustomer = new Customer();
		BeanUtils.copyProperties(customerVO, pcustomer);
		Login login = new Login();
		login.setNoOfAttempt(3);
		login.setLoginid(customerVO.getEmail());
		login.setName(customerVO.getName());
		String genPassword = PasswordGenerator.generateRandomPassword(8);
		customerVO.setPassword(genPassword);
		login.setPassword(bCryptPasswordEncoder.encode(genPassword));
		login.setToken(customerVO.getToken());
		login.setLocked("no");

		Role entity = roleRepository.findById(3).get();
		Set<Role> roles = new HashSet<>();
		roles.add(entity);
		// setting roles inside login
		login.setRoles(roles);
		// setting login inside
		pcustomer.setLogin(login);
		Customer dcustomer = customerRepository.save(pcustomer);
		customerVO.setId(dcustomer.getId());
		customerVO.setUserid(customerVO.getUserid());
		
		/*
		 * CustomerAccountInfoVO customerAccountInfo = new CustomerAccountInfoVO();
		 * String accountNumber = Utils.generateCustomerAccount();
		 * customerAccountInfo.setAccountNumber(accountNumber);
		 */

		Optional<CustomerSaving> optional = customerAccountEnquiryRepository.findByEmail(dcustomer.getEmail());
		if (optional.isPresent()) {
			CustomerSaving customerSaving = optional.get();
			AccountStatus accountStatus = accountStatusRepository.findByCode(AccountStatusEnum.REGISTERED.getCode())
					.get();
			customerSaving.setStatus(accountStatus);
		}
		return customerVO;
	}

	@Override
	public List<CustomerVO> findCustomers() {
		List<Customer> customers = customerRepository.findAll();
		/*
		 * List<CustomerVO> customerVOs=new ArrayList<CustomerVO>(); for(Customer
		 * customer:customers) { CustomerVO customerVO=CustomerMapper.toVO(customer);
		 * customerVOs.add(customerVO); } return customerVOs;
		 */
		return customers.stream(). // Stream<Customer>
				map(CustomerMapper::toVO).// Stream<CustomerVO>
				collect(Collectors.toList()); // List<CustomerVO>
	}

	@Override
	public void updateProfile(CustomerUpdateVO customerVO) {
		// I have loaded entity inside persistence context - >>Session
		Customer customer = customerRepository.findById(customerVO.getCid()).get();
		try {
			customer.setImage(customerVO.getPhoto().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		customer.setName(customerVO.getName());
		customer.setMobile(customerVO.getMobile());
		customer.setDom(new Timestamp(new Date().getTime()));
		/// customerRepository.save(customer);
	}

	@Override
	public byte[] findPhotoByid(int cid) {
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get().getImage();
		} else {
			return null;
		}

	}

	@Override
	public List<RoleVO> getRoles() {

		List<Role> roles = roleRepository.findAll();
		List<RoleVO> rolesVO = new ArrayList<RoleVO>();
		for (Role role : roles) {
			System.out.println("MY ROLE========" + role.toString());
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(role, roleVO);
			rolesVO.add(roleVO);
		}

		return rolesVO;
	}

	@Override
	public String findCustomerByEmail(String email) {
		Optional<CustomerSaving> customer = customerAccountEnquiryRepository.findByEmail(email);
		String result = "";
		if (customer.isPresent()) {
			result = "fail";
		} else
			result = "success";

		return result;
	}

	@Override
	public String findCustomerByMobile(String mobile) {
		Optional<CustomerSaving> customer = customerAccountEnquiryRepository.findByMobile(mobile);
		String result = "";
		if (customer.isPresent()) {
			result = "fail";
		} else
			result = "success";

		return result;
	}

	@Override
	public CustomerVO searchCustomer(String searchKey) {
		Optional<Customer> customer = CustomerRepository.findByName(searchKey.trim());
		CustomerVO customerVO = null;
		if (customer.isPresent()) {
			customerVO = new CustomerVO();
			customerVO.setId(customer.get().getId());
			customerVO.setName(customer.get().getName().trim());
			customerVO.setEmail(customer.get().getEmail());
			customerVO.setAddress(customer.get().getAddress());
			customerVO.setMobile(customer.get().getMobile());
			customerVO.setImage(customer.get().getImage());

		}

		return customerVO;
	}

	@Override
	public List<AccountTypeVO> findAccountTypes() {
		List<AccountType> accounts = accountTypeRepository.findAll();
		List<AccountTypeVO> accountsVO = new ArrayList<AccountTypeVO>();
		for (AccountType account : accounts) {
			AccountTypeVO accountVO = new AccountTypeVO();
			BeanUtils.copyProperties(account, accountVO);
			accountsVO.add(accountVO);
		}
		return accountsVO;
	}

	@Override
	public void addPayee(PayeeInfoVO payeeInfoVO) {
		int urn = Utils.randonUrnNumber();
		System.out.println(urn);
		PayeeStatus payeeStatus = new PayeeStatus();
		payeeStatus.setId(1);
		PayeeInfo payeeInfo = new PayeeInfo();
		payeeInfo.setPayeeStatus(payeeStatus);
		BeanUtils.copyProperties(payeeInfoVO, payeeInfo);
		payeeInfo.setUrn(urn);
		payeeInfo.setDoe(new Timestamp(new Date().getTime()));
		payeeInfo.setDom(new Timestamp(new Date().getTime()));
		payeeRepository.save(payeeInfo);
	}

	@Override
	public List<PayeeInfoVO> pendingPayeeList() {

		List<PayeeInfo> payeeInfoList = payeeRepository.findPendingPayee();
		List<PayeeInfoVO> payeeInfoVOList = new ArrayList<PayeeInfoVO>();
		for (PayeeInfo pi : payeeInfoList) {
			PayeeInfoVO piVO = new PayeeInfoVO();
			piVO.setPayeeStatus(pi.getPayeeStatus().getName());
			BeanUtils.copyProperties(pi, piVO);
			payeeInfoVOList.add(piVO);
		}

		return payeeInfoVOList;
	}

	@Override
	public List<PayeeInfoVO> registeredPayeeList(String id) {

		List<PayeeInfo> payeeInfoList = payeeRepository.findByIdNo(id);
		List<PayeeInfoVO> payeeInfoVOList = new ArrayList<PayeeInfoVO>();
		for (PayeeInfo pi : payeeInfoList) {
			PayeeInfoVO piVO = new PayeeInfoVO();
			piVO.setPayeeStatus(pi.getPayeeStatus().getName());
			BeanUtils.copyProperties(pi, piVO);
			payeeInfoVOList.add(piVO);
		}

		return payeeInfoVOList;
	}

	@Override
	public List<CustomerVO> searchCustomerInfo(String searchText) {
		List<Customer> customerInfoList = customerRepository.findByEmailOrName(searchText, searchText);
		List<CustomerVO> cusList = null;
		if (customerInfoList.size() != 0) {
			cusList = new ArrayList<>();
			for (Customer c : customerInfoList) {
				CustomerVO cuVo = new CustomerVO();
				BeanUtils.copyProperties(c, cuVo, new String[] { "Id" });
				cuVo.setId(c.getId());
				cusList.add(cuVo);
			}
		}
		return cusList;
	}

	@Override
	public byte[] findImgae(String email) {
		byte[] img = null;
		Optional<Customer> c = customerRepository.findByEmail(email);// gets all info from customer table
		img = c.get().getImage();// getting just image
		return img;
	}

	@Override
	public List<String> findAccountType() {
		List<String> accType = accountTypeRepository.findAllAccounts();
		return accType;
	}

	@Override
	public boolean getUrnNumber(int payeeID, int urnNum, String button) {
		Optional<PayeeInfo> payeeInfo = payeeRepository.findById(payeeID);
		int urn = payeeInfo.get().getUrn();
		PayeeStatus payeeStatus = new PayeeStatus();
		if (urn == urnNum && button.equalsIgnoreCase("accept")) {
			payeeStatus.setId(2);
			System.out.println("accept");
			
		} else if (urn != urnNum && button.equalsIgnoreCase("accept")) {
			payeeStatus.setId(1);
			System.out.println("retry");
			System.out.println(urnNum);
			return false;

		} else if (button.equalsIgnoreCase("reject")) {
			System.out.println("reject");
			payeeStatus.setId(3);
			
		}
		payeeInfo.get().setPayeeStatus(payeeStatus);
		System.out.println("service: " + urn);
		System.out.println(urnNum);
		// return urn;
		return true;
	}

	
	@Override 
	public void depositFund(String accNo, float depositAmt, Date date1){ 
		CustomerAccountInfo accountInfo = customerAccountInfoRepository.findByAccountNumber(accNo).get();
		accountInfo.setStatusAsOf(date1);
		accountInfo.setAvBalance(depositAmt + accountInfo.getAvBalance());
		accountInfo.setTavBalance(depositAmt);
		
	  }

	@Override
	public String getAccountNumber(LoginVO loginVO) {
		Login login = loginRepo.findByLoginid(loginVO.getUsername()).get();
		CustomerAccountInfo accountNoInfo = customerAccountInfoRepository.findByCustomerId(login);
		return accountNoInfo.getAccountNumber();
	}
	 

}
