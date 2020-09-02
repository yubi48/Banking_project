package com.rab3tech.dao.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author nagendra.yadav
 * 00051230383783
 * 
 */
@Entity
@Table(name="customer_account_information_tbl")
public class CustomerAccountInfo {

	private long id;
	private Login customerId;
	private String accountNumber;
	private String currency;
	private String branch;
	private float tavBalance;
	private float avBalance;
	private Date StatusAsOf;
	private AccountType accountType;
	

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false)
	public Login getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Login customerId) {
		this.customerId = customerId;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountType", nullable = false)
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CustomerAccountInfo [id=" + id + ", customerId=" + customerId
				+ ", accountNumber=" + accountNumber + ", currency=" + currency
				+ ", branch=" + branch + ", tavBalance=" + tavBalance
				+ ", avBalance=" + avBalance + ", StatusAsOf=" + StatusAsOf
				+ "]";
	}
	
	

}

