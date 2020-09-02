package com.rab3tech.customer.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rab3tech.dao.entity.CustomerSavingApproved;

/**
 * 
 * @author nagendra
 * comment
 * 
 * Spring Data JPA repository
 *
 */
public interface CustomerAccountApprovedRepository extends JpaRepository<CustomerSavingApproved, Integer> {
	
	Optional<CustomerSavingApproved> findByEmail(String email);
	Optional<CustomerSavingApproved> findByUcrid(String ucrid);

	@Query("SELECT tt FROM CustomerSavingApproved tt where tt.status.name = :name") 
	List<CustomerSavingApproved> findPendingEnquiries(@Param("name") String name);
}

