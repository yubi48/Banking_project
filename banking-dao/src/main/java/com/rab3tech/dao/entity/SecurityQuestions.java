package com.rab3tech.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_security_questions_tbl")
public class SecurityQuestions {
	
	private int qid;
	private String questions;
	private String status;
	private String owner;
	private Timestamp createdate;
	private Timestamp updatedate;
		
	
	public SecurityQuestions() {}
	
	
	
	public SecurityQuestions(int qid, String questions, String status, String owner, Timestamp createdate,
			Timestamp updatedate) {
		super();
		this.qid = qid;
		this.questions = questions;
		this.status = status;
		this.owner = owner;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}



	public SecurityQuestions(int qid, String questions) {
		super();
		this.qid = qid;
		this.questions = questions;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	
	@Column(length=3)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length=100)
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "SecurityQuestions [qid=" + qid + ", questions=" + questions
				+ "]";
	}
	
	
	
}
