package com.dhanrajapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_table")
public class LoginBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String staffid;
	private String password;     
	private String seniority;
	private String admin;
	private long license;
	public long getLicense() {
		return license;
	}


	public void setLicense(long license) {
		this.license = license;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}


	public LoginBean() {
		
	}
	

	public LoginBean(String staffid, String password, String seniority, String admin,long id) {
		this.staffid = staffid;
		this.password = password;
		this.seniority = seniority;
		this.admin = admin;
		this.license=id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSeniority() {
		return seniority;
	}
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	
	  @Override public String toString() { return "LoginBean [id=" + id +
	  ", staffid=" + staffid + ", password=" + password + ", seniority=" +
	  seniority + ", admin=" + admin + "]"; }
	 
	
	
}
