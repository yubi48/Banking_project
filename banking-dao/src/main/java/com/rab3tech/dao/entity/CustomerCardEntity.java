package com.rab3tech.dao.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="credit_card_tbl")
public class CustomerCardEntity {

	private long cardNumber;
	
	@DateTimeFormat
	private Date expDate;
	
	private Customer customer;
	private double currentBalance;
	private double apr;
	private double monthlyPayment;
	private int creditScore;
	private int cvv;
	
	
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CustomerId",referencedColumnName="id")
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
	public	int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	@Override
	public String toString() {
		return "CustomerCardEntity [cardNumber=" + cardNumber + ", expDate=" + expDate + ", customer=" + customer
				+ ", currentBalance=" + currentBalance + ", apr=" + apr + ", monthlyPayment=" + monthlyPayment
				+ ", creditScore=" + creditScore + ", cvv=" + cvv + "]";
	}
	
	
	
}
