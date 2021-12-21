package com.example.demo.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCustomer {

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Phone")
	private String phone;
	@JsonProperty("Address")
	private String address;
	@JsonProperty("Gender")
	private int Gender;
	@JsonProperty("Avata")
	private String avatar;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getGender() {
		return Gender;
	}

	public void setGender(int gender) {
		Gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}
