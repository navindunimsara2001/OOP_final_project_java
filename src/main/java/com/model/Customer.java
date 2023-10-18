package com.model;

public class Customer {
	// attributes
	private String name;
	private String email;
	private String phone;
	private String DOB;
	private String password;
	private String gender;
	private String district;
	
	// getters & setters
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDOB() {
		return DOB;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getDistrict() {
		return district;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
