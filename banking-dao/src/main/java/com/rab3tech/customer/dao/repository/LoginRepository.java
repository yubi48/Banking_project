package com.rab3tech.customer.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rab3tech.dao.entity.Login;

/**
 * 
 * @author nagendra
 * 
 * Spring Data JPA repository
 *
 */
public interface LoginRepository extends JpaRepository<Login, String> {
	
	public Optional<Login> findByLoginidAndPassword(String loginid,String password);
	public Optional<Login> findByLoginid(String loginid);
	
	@Modifying
	//JPQL - JPA Query Langauge
	@Query("update Login lp set lp.password = :ppassword,lp.lwap=null,lp.token='' where lp.loginid = :login and lp.token = :passcode")
	void updateLoginPassword(@Param("ppassword") String ppassword,@Param("login") String login,@Param("passcode") String passcode);
	
	public Optional<Login> findByLoginidAndToken(String loginid,String token);
}

