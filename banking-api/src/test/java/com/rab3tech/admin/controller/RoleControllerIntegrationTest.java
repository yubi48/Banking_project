package com.rab3tech.admin.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rab3tech.vo.RoleVO;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
@ActiveProfiles("test")
public class RoleControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetRoleVO() {
		//TestRestTemplate = this wrapper on Http Client
		//calling rest
		ResponseEntity<RoleVO> responseEntity = restTemplate.getForEntity("/v3/roles/100",	RoleVO.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("ADMIN_ROLE",responseEntity.getBody().getName());
		assertEquals(100,responseEntity.getBody().getId());
	}

}
