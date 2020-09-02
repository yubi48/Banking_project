package com.rab3tech.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payee_informations_tbl")
public class PayeeInfo implements Serializable{
	private int id;
	private String payeeAccountNo;
	private String payeeName;
	private String payeeNickName;
	private String customerId;
	private Timestamp doe;
	private Timestamp dom;
	private String remarks;
	private PayeeStatus payeeStatus;
	private int urn;
	
	
	public PayeeInfo() {
	
	}
	public PayeeInfo(int id, String payeeAccountNo, String payeeName, String payeeNickName, String customerId,
			Timestamp doe, Timestamp dom, String remarks, PayeeStatus payeeStatus, int urn) {
		
		this.id = id;
		this.payeeAccountNo = payeeAccountNo;
		this.payeeName = payeeName;
		this.payeeNickName = payeeNickName;
		this.customerId = customerId;
		this.doe = doe;
		this.dom = dom;
		this.remarks = remarks;
		this.payeeStatus = payeeStatus;
		this.urn = urn;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Timestamp getDoe() {
		return doe;
	}
	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	public Timestamp getDom() {
		return dom;
	}
	public void setDom(Timestamp dom) {
		this.dom = dom;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payeeStatus", nullable = false)
	public PayeeStatus getPayeeStatus() {
		return payeeStatus;
	}
	public void setPayeeStatus(PayeeStatus payeeStatus) {
		this.payeeStatus = payeeStatus;
	}
	public int getUrn() {
		return urn;
	}
	public void setUrn(int urn) {
		this.urn = urn;
	}
	@Override
	public String toString() {
		return "PayeeInfo [id=" + id + ", payeeAccountNo=" + payeeAccountNo + ", payeeName=" + payeeName
				+ ", payeeNickName=" + payeeNickName + ", customerId=" + customerId + ", doe=" + doe + ", dom=" + dom
				+ ", remarks=" + remarks + ", payeeStatus=" + payeeStatus + ", urn=" + urn + "]";
	}
	
	
	
}
