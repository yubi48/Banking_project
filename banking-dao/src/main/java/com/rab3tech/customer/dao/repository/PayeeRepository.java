package com.rab3tech.customer.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.PayeeInfo;


public interface PayeeRepository extends JpaRepository<PayeeInfo, Integer>  {

	@Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 1") 
	List<PayeeInfo> findPendingPayee();
	
	@Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 2 and tt.customerId = ?1")
	 List<PayeeInfo> findByIdNo(String id);
}
