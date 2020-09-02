package com.rab3tech.vo;

import com.rab3tech.dao.entity.Customer;

public class CustomerCardEntityVO {

	private long cardNumber;
	private Customer customer;
	private double currentBalance;
	private double apr;
	private double monthlyPayment;
	private long creditScore;
	
	
	
	public long getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public double getCurrentBalance() {
		return currentBalance;
	}



	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}



	public double getApr() {
		return apr;
	}



	public void setApr(double apr) {
		this.apr = apr;
	}



	public double getMonthlyPayment() {
		return monthlyPayment;
	}



	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}



	public long getCreditScore() {
		return creditScore;
	}



	public void setCreditScore(long creditScore) {
		this.creditScore = creditScore;
	}



	@Override
	public String toString() {
		return "CustomerCardEntityVO [cardNumber=" + cardNumber + ", customer=" + customer + ", currentBalance="
				+ currentBalance + ", apr=" + apr + ", monthlyPayment=" + monthlyPayment + ", creditScore="
				+ creditScore + "]";
	}
	
	
	
}
