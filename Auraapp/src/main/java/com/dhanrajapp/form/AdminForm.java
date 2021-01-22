package com.dhanrajapp.form;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.struts.action.ActionForm;

public class AdminForm extends ActionForm{
	private String sene;
	private String staffid;
	private String pass;

	public String getSene() {
		return sene;
	}


	public void setSene(String sene) {
		this.sene = sene;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public AdminForm() {
		// TODO Auto-generated constructor stub
	}
	
}
