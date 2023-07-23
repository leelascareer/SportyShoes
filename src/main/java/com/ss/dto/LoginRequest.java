package com.ss.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LoginRequest {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="pwd")
	private String pwd;

	public LoginRequest() {
	}
	
	public LoginRequest(int userid, String emailid, String pwd) {
		this.userid = userid;
		this.emailid = emailid;
		this.pwd = pwd;
	}
	
	public LoginRequest(String emailid, String pwd) {
		this.emailid = emailid;
		this.pwd = pwd;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	

}
