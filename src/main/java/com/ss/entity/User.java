package com.ss.entity;

import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "users", uniqueConstraints=
@UniqueConstraint(columnNames={"emailid"}))
public class User {
	
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="l_name")
	private String l_name;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="ph")
	private long ph;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="role")
	private String role;
	
	/*
	 * @OneToMany(targetEntity = User.class, cascade =
	 * CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn //private Order order;
	 * private TreeSet<Order> order = new TreeSet<>();
	 */
	
	//Baeldung says: "whoever owns the foreign key column gets the @JoinColumn annotation"
	
	/*
	 * @OneToOne(mappedBy = "user", cascade =
	 * CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private Order order;
	 */
	
	
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<Order> order;
	
	
	public User(int userid, String f_name, String l_name, String emailid,
			String pwd, long ph, int age, char gender, String role,
			Set<Order> order) {
		super();
		this.userid = userid;
		this.f_name = f_name;
		this.l_name = l_name;
		this.emailid = emailid;
		this.pwd = pwd;
		this.ph = ph;
		this.age = age;
		this.gender = gender;
		this.role = role;
		this.order = order;
	}

	public User(){
	}

	public User(int userid, String f_name, String l_name, String emailid,
			String pwd, long ph, int age, char gender, String role) {
		this.userid = userid;
		this.f_name = f_name;
		this.l_name = l_name;
		this.emailid = emailid;
		this.pwd = pwd;
		this.ph = ph;
		this.age = age;
		this.gender = gender;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
