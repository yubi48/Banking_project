package com.rab3tech.admin.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.LoginService;
import com.rab3tech.vo.ApplicationResponseVO;
import com.rab3tech.vo.RoleVO;
import com.rab3tech.vo.RoleVOWrapper;
import com.rab3tech.vo.RolesUpdateRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
public class RoleController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/roles/{rid}")
	@ResponseStatus(HttpStatus.OK)
	public RoleVO getRoleVO(@PathVariable int rid) {
		RoleVO roleVO=new RoleVO();
		roleVO.setId(rid);	
		roleVO.setName("ADMIN_ROLE");
		roleVO.setDescription("This super power role!");
		roleVO.setDoe(new Timestamp(new Date().getTime()));
		roleVO.setDom(new Timestamp(new Date().getTime()));
		return roleVO;
	}
	
	
	@GetMapping("/roles")
	@ResponseStatus(HttpStatus.OK)
	public List<RoleVO> getRoles() {
		return loginService.findRoles();
	}
	
	
	@PutMapping("/customer/roles")
	public ApplicationResponseVO updateCustomerRoles(@RequestBody RolesUpdateRequest rolesUpdateRequest) {
		loginService.updateCustomerRoles(rolesUpdateRequest);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode(201);
		applicationResponseVO.setStatus("success");
		applicationResponseVO.setMessage("Roles is updated successfully.");
		return applicationResponseVO;
	}
	

	@GetMapping("/customer/roles")
	@ResponseStatus(HttpStatus.OK)
	public RoleVOWrapper getCustomerRoles(@RequestParam String userid) {
		List<RoleVO> customerRoles=loginService.findRolesByUserid(userid);
		List<RoleVO> roleVOs=loginService.findRoles();
		RoleVOWrapper roleVOWrapper=new RoleVOWrapper();
		
		List<Integer>  customersId=customerRoles.stream().map(r->r.getId()).collect(Collectors.toList());
		roleVOWrapper.setCurrentRoles(customersId);
		roleVOWrapper.setRoleVOs(roleVOs);
		return roleVOWrapper;
	}

}
