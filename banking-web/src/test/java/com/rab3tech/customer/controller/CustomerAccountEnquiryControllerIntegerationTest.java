package com.rab3tech.customer.controller;

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

import com.rab3tech.vo.CustomerSavingVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
@ActiveProfiles("test")
public class CustomerAccountEnquiryControllerIntegerationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetgEnquiry() {
		ResponseEntity<CustomerSavingVO> responseEntity = restTemplate.getForEntity("/v3/customers/enquiry/8",
				CustomerSavingVO.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("javahunk2020@gmail.com", responseEntity.getBody().getEmail());
		assertEquals("JavaHunk Technologies", responseEntity.getBody().getName());
	}

}
