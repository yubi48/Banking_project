package com.rab3tech.admin.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.Customer;

/**
 * 
 * @author nagendra
 * 
 * 
 * Spring Data JPA repository
 * 
 * 
 * 
 */
public interface MagicCustomerRepository extends JpaRepository<Customer, Integer> {
	public Optional<Customer> findByEmail(String email);
	
	@Query("Select t from Customer t where t.email like %?1% Or t.name like %?2%")
	public List<Customer> findByEmailOrName(String searchText, String search);
}



