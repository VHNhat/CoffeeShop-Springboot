package com.example.demo.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAccountDto {

	@JsonProperty("Username")
	private String username;

	@JsonProperty("Password")
	private String password;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Avatar")
	private String avatar;

	@JsonProperty("RoleId")
	private long roleId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
