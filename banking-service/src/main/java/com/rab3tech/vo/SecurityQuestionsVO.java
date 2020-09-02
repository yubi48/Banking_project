package com.rab3tech.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SecurityQuestionsVO {
	
	private int qid;
	private String questions;
	private String status;
	private String owner;
	private Timestamp createdate;
	private Timestamp updatedate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
		return "SecurityQuestionsVO [qid=" + qid + ", questions=" + questions + ", status=" + status + ", owner="
				+ owner + ", createdate=" + createdate + ", updatedate=" + updatedate + "]";
	}
		
		
}
