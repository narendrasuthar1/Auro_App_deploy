package com.dhanrajapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "license_table")
public class LicenseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String no_of_staff;
	private String Licregndt;
	private String licexpdt;
	
	public LicenseBean() {
		// TODO Auto-generated constructor stub
	}
	
	public LicenseBean(String name, String address, String mobile, String email, String no_of_staff,
			String licregndt, String licexpdt) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.no_of_staff = no_of_staff;
		this.Licregndt = licregndt;
		this.licexpdt = licexpdt;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNo_of_staff() {
		return no_of_staff;
	}

	public void setNo_of_staff(String no_of_staff) {
		this.no_of_staff = no_of_staff;
	}

	public String getLicregndt() {
		return Licregndt;
	}

	public void setLicregndt(String licregndt) {
		Licregndt = licregndt;
	}

	public String getLicexpdt() {
		return licexpdt;
	}

	public void setLicexpdt(String licexpdt) {
		this.licexpdt = licexpdt;
	}

	@Override
	public String toString() {
		return "LicenseBean [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", no_of_staff=" + no_of_staff + ", Licregndt=" + Licregndt + ", licexpdt=" + licexpdt + "]";
	}
	
	
}
