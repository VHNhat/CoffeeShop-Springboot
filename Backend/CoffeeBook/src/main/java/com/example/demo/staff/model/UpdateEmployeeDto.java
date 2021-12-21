package com.example.demo.staff.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateEmployeeDto {

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Age")
	private int age;

	@JsonProperty("Gender")
	private int gender;

	@JsonProperty("Email")
	private String email;

	@JsonProperty("Phone")
	private String phone;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("Salary")
	private long salary;
	
	@JsonProperty("StoreId")
	private long StoreId;

	
	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getStoreId() {
		return StoreId;
	}

	public void setStoreId(long storeId) {
		StoreId = storeId;
	}
	
	
}
