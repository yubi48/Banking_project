package com.rab3tech.vo;

import java.util.Date;

public class CustomerAccountInfoVO {
	private long id;
	private LoginVO customerId;
	private String accountNumber;
	// private String confirmaccountNumber;
	private String currency;
	private String branch;
	private float tavBalance;
	private float avBalance;
	private Date StatusAsOf;
	private String name;
	private AccountTypeVO accountType;
	private String acccountType;

	public String getAcccountType() {
		return acccountType;
	}

	public void setAcccountType(String acccountType) {
		this.acccountType = acccountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LoginVO getCustomerId() {
		return customerId;
	}

	public void setCustomerId(LoginVO customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getTavBalance() {
		return tavBalance;
	}

	public void setTavBalance(float tavBalance) {
		this.tavBalance = tavBalance;
	}

	public float getAvBalance() {
		return avBalance;
	}

	public void setAvBalance(float avBalance) {
		this.avBalance = avBalance;
	}

	public Date getStatusAsOf() {
		return StatusAsOf;
	}

	public void setStatusAsOf(Date statusAsOf) {
		StatusAsOf = statusAsOf;
	}

	public AccountTypeVO getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeVO accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "CustomerAccountInfoVO [id=" + id + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", currency=" + currency + ", branch=" + branch + ", tavBalance=" + tavBalance + ", avBalance="
				+ avBalance + ", StatusAsOf=" + StatusAsOf + ", name=" + name + ", accountType=" + accountType
				+ ", acccountType=" + acccountType + "]";
	}

}
