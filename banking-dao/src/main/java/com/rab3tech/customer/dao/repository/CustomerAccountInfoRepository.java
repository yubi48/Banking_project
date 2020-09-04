package com.rab3tech.customer.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.CustomerAccountInfo;
import com.rab3tech.dao.entity.Login;

public interface CustomerAccountInfoRepository extends JpaRepository<CustomerAccountInfo, Long> {

	Optional<CustomerAccountInfo> findByAccountNumber(String accNo);
	
	CustomerAccountInfo findByCustomerId(Login login);

	/*
	 * @Query("UPDATE aa from CustomerAccountInfo aa where aa.customerId=1? ")
	 * String addAccountNo(String id);
	 */
}
