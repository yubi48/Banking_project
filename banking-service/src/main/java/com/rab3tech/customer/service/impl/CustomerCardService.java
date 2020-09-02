package com.rab3tech.customer.service.impl;

import java.util.Date;

public interface CustomerCardService {

	

	String generateCardNumber();

	String generateCCVNumber();

	Date generateExpireDate();

	public byte[] generateFrontCreditCard(String name, String number,String expireDate);

	byte[] generateBackCreditCard(String cvv);

	void saveCardData(String name, String number, Date expireDate);

}
