package com.rab3tech.customer.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.impl.CustomerCardService;

@RestController
@RequestMapping("/v4")
public class CustomerCardController {
private String cardNum;
private Date expDate;
	@Autowired		
	private CustomerCardService cardService; 
	
	@GetMapping("/card/floadCard")
	public void generatefNewCard(@RequestParam String name, HttpServletResponse response) throws IOException {
		
		response.setContentType("img.jpg");
		
		String cnumber = cardService.generateCardNumber();
		//String ccvv = cardService.generateCCVNumber();
		Date CExpire = cardService.generateExpireDate();;
		this.cardNum=cnumber;
		this.expDate=CExpire;
		System.out.println(CExpire);
		String exp=CExpire.toString().substring(4, 7) + "/" + CExpire.toString().substring(24, 28);;
		System.out.println(exp);
		
		byte[] photo = cardService.generateFrontCreditCard(name,cnumber,exp);
		//byte[]photo2 = cardService.generateBackCreditCard(ccvv);
		ServletOutputStream outputStream = response.getOutputStream();
		if(photo != null && photo.length>0) {
			outputStream.write(photo);
			outputStream.flush();
		}
		outputStream.close();
	}
	
	@GetMapping("/card/bloadCard")
	public void generatebNewCard(HttpServletResponse response) throws IOException {
		String cvv = cardService.generateCCVNumber();
		response.setContentType("img.jpg");
		
		byte[] photo = cardService.generateBackCreditCard(cvv);
		ServletOutputStream outputStream = response.getOutputStream();
		if(photo != null && photo.length>0) {
			outputStream.write(photo);
			outputStream.flush();
		}
		outputStream.close();
	}
	
	@GetMapping("/customer/cardSave")
	public void saveCustomerCard(@RequestParam String name) {
		//System.out.println("I am controller");
		//long cardNumber = Long.parseLong(number);
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/YY");
		//Date date = (Date) formatter.parse(expireDate);
		//String cvv = generateCCVNumber();
		//int ccvv = Integer.parseInt(cvv);
		
		//System.out.println(expDate);
		//System.out.println("I am controller1");
		cardService.saveCardData(name, cardNum, expDate);
	}

	
	
}
