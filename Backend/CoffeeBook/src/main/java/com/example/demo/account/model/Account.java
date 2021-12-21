package com.example.demo.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.demo.commondata.model.AbstractEntity;
import com.example.demo.role.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Account")
@Getter
@Setter
public class Account extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(min = 3, max = 50)
	@Column(unique = true, name = "Username", nullable = false)
	@JsonProperty("Username")
	private String username;

	@Size(min = 3, max = 50)
	@Column(name = "Password", nullable = false)
	@JsonProperty("Password")
	private String password;

	@Size(min = 3, max = 100)
	@Column(name = "name", nullable = true)
	@JsonProperty("Name")
	private String name;

	@Size(max = 5000)
	@Column(name = "avatar", nullable = true, length = 5000)
	@JsonProperty("Avatar")
	private String avatar;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = true)
	@JsonProperty("Role")
	private Role role;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

}
