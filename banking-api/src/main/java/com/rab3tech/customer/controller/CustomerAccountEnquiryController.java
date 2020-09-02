package com.rab3tech.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.service.exception.BankServiceException;
import com.rab3tech.vo.CustomerSavingVO;
import com.rab3tech.vo.CustomerVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
@Api(value = "Operations pertaining to Customer and it;s account")
public class CustomerAccountEnquiryController {

	@Autowired
	private CustomerEnquiryService customerEnquiryService;

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Saving enquiry details for the customer", response = CustomerSavingVO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/customers/enquiry")
	public CustomerSavingVO saveEnquiry(@RequestBody CustomerSavingVO customerSavingVO) {
		// write code for email validation;
		CustomerSavingVO response = null;
		boolean status = customerEnquiryService.emailNotExist(customerSavingVO.getEmail());
		if (status) {
			response = customerEnquiryService.save(customerSavingVO);
		} else {
			throw new BankServiceException("Sorry , this email is already in use " + customerSavingVO.getEmail());
		}
		return response;
	}

	@ApiOperation(value = "find all enquiry details for the customers", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/customers/enquiry")
	public List<CustomerSavingVO> getAllEnquiry() {
		List<CustomerSavingVO> responses = customerEnquiryService.findAll();
		return responses;
	}

	@ApiOperation(value = "find all pending enquiry details for the customers", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/customers/enquiry/pending")
	public List<CustomerSavingVO> getAllPendingEnquiry() {
		List<CustomerSavingVO> responses = customerEnquiryService.findPendingEnquiry();
		return responses;
	}

	@ApiOperation(value = "find customer enquiry details for a customer", response = CustomerSavingVO.class)
	@ApiParam(value = "csaid -> custmer application id to fecth customer enquiry details")
	@GetMapping(value = "/customers/enquiry/{csaid}")
	public CustomerSavingVO getEnquiry(@PathVariable int csaid) {
		CustomerSavingVO response = customerEnquiryService.findById(csaid);
		return response;
	}

	@GetMapping("/customer/app/status")
	public CustomerSavingVO findCustomerStatus(@RequestParam String searchText) {

		CustomerSavingVO customerVo = customerEnquiryService.findAppStatus(searchText);

		return customerVo;
	}

	@GetMapping("/customer/customerSearch")
	public List<CustomerVO> searchCustomer(@RequestParam String searchText) {
		List<CustomerVO> customerVOs = new ArrayList<>();
		customerVOs = customerService.searchCustomerInfo(searchText);
		return customerVOs;
	}

	@GetMapping("/load/image")
	public void searchPhoto(@RequestParam String email, HttpServletResponse reponse) throws IOException {

		reponse.setContentType("image/png");

		byte[] photo = customerService.findImgae(email);
		ServletOutputStream outputStream = reponse.getOutputStream();
		if (photo != null && photo.length > 0) {
			outputStream.write(photo);
			outputStream.flush();
		}
		outputStream.close();
	}

	@GetMapping("/customer/payeeStatusInfo")
	public String payeeStatusInfo(@RequestParam int id, @RequestParam int urnNum, @RequestParam String buttons,
			Model model) {
		if (!customerService.getUrnNumber(id, urnNum, buttons)) {
			return "";

		}
		
		return "/customer/registeredPayee";
	}

}
