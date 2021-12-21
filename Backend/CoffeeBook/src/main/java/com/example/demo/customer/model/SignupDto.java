package com.example.demo.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupDto {

	@JsonProperty("Username")
	private String username;
	@JsonProperty("Password")
	private String password;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Phone")
	private String phone;
	@JsonProperty("ConfirmPassword")
	private String confirmPassword;
	@JsonProperty("Name")
	private String name;

	// Getters & Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
