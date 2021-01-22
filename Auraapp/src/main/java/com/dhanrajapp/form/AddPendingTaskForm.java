package com.dhanrajapp.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.db.LoginDao;

public class AddPendingTaskForm extends ActionForm{
	
	LoginDao dao=new LoginDao();
	List<String> beans=dao.getStaffid();
	
	private String staffId;
	private String clientName;
	private String pendingText;
	
	private String searchbar;
	
	
	
	public String getSearchbar() {
		return searchbar;
	}

	public void setSearchbar(String searchbar) {
		this.searchbar = searchbar;
	}

	public AddPendingTaskForm() {
	}
	
	private List<String> staffList=(List<String>)(List<?>)beans;
	public List<String> getStaffList() {
		staffList=(List<String>)(List<?>)beans;
		return staffList;
	}

	public void setStaffList(List<String> staffList) {
		this.staffList =staffList;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPendingText() {
		return pendingText;
	}

	public void setPendingText(String pendingText) {
		this.pendingText = pendingText;
	}		
}