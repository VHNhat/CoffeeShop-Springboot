package com.example.demo.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminLoginResponse {
	
	@JsonProperty("Id")
	private long id;
	
	@JsonProperty("Username")
	private String username;
	
	@JsonProperty("RoleId")
	private Long roleId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
}
