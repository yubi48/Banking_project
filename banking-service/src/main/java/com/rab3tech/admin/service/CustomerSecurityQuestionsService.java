package com.rab3tech.admin.service;

import java.util.List;

import com.rab3tech.vo.SecurityQuestionsVO;

public interface CustomerSecurityQuestionsService {

	List<SecurityQuestionsVO> findSecurityQuestions();
	void updateStatus(String status, int qid);
	void addSecurityQuestion(String question, String loginid);

}
