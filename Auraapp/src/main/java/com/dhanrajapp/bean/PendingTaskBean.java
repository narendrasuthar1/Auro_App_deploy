package com.dhanrajapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pendingtask_table")
public class PendingTaskBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String task;
	private String urg;
	private String staffid;
	private String status;
	private String remark;
	private String task_status;
	private long license;
	
	public long getLicense() {
		return license;
	}
	public void setLicense(long license) {
		this.license = license;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	public String getUrg() {
		return urg;
	}
	public void setUrg(String urg) {
		this.urg = urg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public PendingTaskBean() {
		// TODO Auto-generated constructor stub
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
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	
}
