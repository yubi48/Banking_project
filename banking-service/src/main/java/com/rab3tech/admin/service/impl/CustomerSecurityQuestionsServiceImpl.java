package com.rab3tech.admin.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.admin.dao.repository.CustomerSecurityQuestionsRepository;
import com.rab3tech.admin.service.CustomerSecurityQuestionsService;
import com.rab3tech.dao.entity.SecurityQuestions;
import com.rab3tech.vo.SecurityQuestionsVO;

@Service
@Transactional
public class CustomerSecurityQuestionsServiceImpl  implements CustomerSecurityQuestionsService{
	
	@Autowired
	private CustomerSecurityQuestionsRepository customerSecurityQuestionsDao;
	
	@Override
	public void updateStatus(String status,int qid) {
		//entity is loaded inside session - persistence context
		SecurityQuestions securityQuestions=customerSecurityQuestionsDao.findById(qid).get();
		if("yes".equalsIgnoreCase(status)) {
			status="no";
		}else {
			status="yes";
		}
		securityQuestions.setStatus(status);
	}
	
	@Override
	public List<SecurityQuestionsVO> findSecurityQuestions() {
		List<SecurityQuestions> securityQuestions=customerSecurityQuestionsDao.findAll();
		List<SecurityQuestionsVO>  questionsVOs=new ArrayList<>();
		for(SecurityQuestions entity:securityQuestions) {
			SecurityQuestionsVO questionsVO=new SecurityQuestionsVO();
			BeanUtils.copyProperties(entity, questionsVO);
			questionsVOs.add(questionsVO);
		}
		return questionsVOs;
	}

	@Override
	public void addSecurityQuestion(String question, String loginid) {
		SecurityQuestions securityQuestions=new SecurityQuestions (0,question,"yes",loginid,new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
		customerSecurityQuestionsDao.save(securityQuestions);
	}

}
