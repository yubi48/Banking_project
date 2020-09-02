package com.rab3tech.admin.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.AccountStatus;

/**
 * 
 * @author nagendra
 * 
 * Elastic Search , MongoDb
 *
 */
public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {
	public Optional<AccountStatus> findByName(String name);
	public Optional<AccountStatus> findByCode(String code);
	public Optional<AccountStatus> findByCodeAndName(String code,String name);
}

