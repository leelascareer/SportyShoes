package com.ss.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserRequest {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="f_name")
	private String f_name;

	@Column(name="l_name")
	private String l_name;
		
	@Column(name="ph")
	private long ph;
	
	public UserRequest(int userid, String emailid, String f_name, String l_name,
			long ph, int age, char gender, String role) {
		this.userid = userid;
		this.emailid = emailid;
		this.f_name = f_name;
		this.l_name = l_name;
		this.ph = ph;
		this.age = age;
		this.gender = gender;
		this.role = role;
	}

	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="role")
	private String role;

	
	public UserRequest() {
	}
	
	public UserRequest(int userid, String emailid) {
		this.userid = userid;
		this.emailid = emailid;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public long getPh() {
		return ph;
	}

	public void setPh(long ph) {
		this.ph = ph;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
