package com.dhanrajapp.form;

import org.apache.struts.action.ActionForm;

public class TaskDoneForm extends ActionForm{

	private String staffId;
	private String actper;
	
 public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getActper() {
		return actper;
	}

	public void setActper(String actper) {
		this.actper = actper;
	}

public TaskDoneForm() {
	// TODO Auto-generated constructor stub

 }
 
}
