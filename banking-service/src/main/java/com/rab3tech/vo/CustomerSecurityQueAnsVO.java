package com.rab3tech.vo;

import java.util.List;

public class CustomerSecurityQueAnsVO {
	private String securityQuestion1;
	private String securityQuestion2;
	private String securityQuestionAnswer2;
	private String securityQuestionAnswer1;
	private String loginid;
	
	
	
	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	List<SecurityQuestionsVO> questionsVOs;

	public String getSecurityQuestion1() {
		return securityQuestion1;
	}

	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	public String getSecurityQuestion2() {
		return securityQuestion2;
	}

	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

	public String getSecurityQuestionAnswer2() {
		return securityQuestionAnswer2;
	}

	public void setSecurityQuestionAnswer2(String securityQuestionAnswer2) {
		this.securityQuestionAnswer2 = securityQuestionAnswer2;
	}

	public String getSecurityQuestionAnswer1() {
		return securityQuestionAnswer1;
	}

	public void setSecurityQuestionAnswer1(String securityQuestionAnswer1) {
		this.securityQuestionAnswer1 = securityQuestionAnswer1;
	}

	public List<SecurityQuestionsVO> getQuestionsVOs() {
		return questionsVOs;
	}

	public void setQuestionsVOs(List<SecurityQuestionsVO> questionsVOs) {
		this.questionsVOs = questionsVOs;
	}
	
}
