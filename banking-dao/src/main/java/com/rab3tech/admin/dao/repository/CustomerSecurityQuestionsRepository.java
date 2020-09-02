package com.rab3tech.admin.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.SecurityQuestions;

/**
 * 
 * @author nagendra
 *
 */
public interface CustomerSecurityQuestionsRepository extends JpaRepository<SecurityQuestions, Integer> {

}

