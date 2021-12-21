package com.example.demo.account.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginDto {

	@NotBlank(message = "{account.username.notblank}")
	@Size(min = 3, max = 50)
	@JsonProperty("Username")
	private String username;

	@NotBlank(message = "{account.password.notblank}")
	@Size(min = 3, max = 50)
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
