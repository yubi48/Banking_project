package com.rab3tech.customer.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.CustomerAccountInfo;

public interface CustomerAccountInfoRepository extends JpaRepository<CustomerAccountInfo, Long> {

	/*
	 * @Query("UPDATE aa from CustomerAccountInfo aa where aa.customerId=1? ")
	 * String addAccountNo(String id);
	 */
}
