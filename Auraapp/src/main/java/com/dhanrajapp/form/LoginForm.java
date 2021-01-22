package com.dhanrajapp.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{

	private String staffId;
	private String password;
	private String licenseNo;
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public LoginForm() {
		// TODO Auto-generated constructor stub
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}