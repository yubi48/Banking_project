package com.rab3tech.vo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author 
 *  This is pojo/model which is used to carry data from view to model/controller
 *  88282828
 */
public class CustomerVO {
	
	private int id;
	private String userid;
	private String password;
	private String name;
	private String address;
	private String email;
	private String mobile;
	private String ssn;
	private int age;
	private String gender;
	private String dob;
	private String father;
	private String qualification;
	private String jobTitle;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	
	private String approved;
	private String locked;
    private String accountNum;
    
    private String photoName;
    private byte[] image;
    private String role;
    private String token;
    private Timestamp doe;
    
    public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}



	private List<Integer> roleids;
    
	
	public List<Integer> getRoleids() {
		return roleids;
	}

	public void setRoleids(List<Integer> roleids) {
		this.roleids = roleids;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}
	
	/*public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}*/

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	

	@Override
	public String toString() {
		return "CustomerForm [id=" + id + ", userid=" + userid + ", password="
				+ password + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + ", ssn=" + ssn
				+ ", age=" + age + ", gender=" + gender + ", dob=" + dob
				+ ", father=" + father + ", qualification=" + qualification
				+ ", jobTitle=" + jobTitle + ", question1=" + question1
				+ ", answer1=" + answer1 + ", question2=" + question2
				+ ", answer2=" + answer2 + ", approved=" + approved
				+ ", accountNum=" + accountNum + ", photoName=" + photoName
				+ ", image=" + Arrays.toString(image) + "]";
	}

}
