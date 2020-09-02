package com.rab3tech.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.admin.service.CustomerSecurityQuestionsService;
import com.rab3tech.vo.ApplicationResponseVO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
public class CustomerSecurityQuesController {
	
	@Autowired
	private CustomerSecurityQuestionsService securityQuestionsService;
	
	@GetMapping("/security/uquestion")
	public ApplicationResponseVO updateSecurityQuestionStatus(String status,int qid) {
		securityQuestionsService.updateStatus(status, qid);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode(200);
		applicationResponseVO.setMessage("Customer security question status is updated");
		applicationResponseVO.setStatus("success");
		return applicationResponseVO;
	}
}
