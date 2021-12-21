package com.example.demo.customer.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SigninDto {

	@NotBlank
	@JsonProperty("Username")
	private String username;
	@NotBlank
	@JsonProperty("Password")
	private String password;

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

}
