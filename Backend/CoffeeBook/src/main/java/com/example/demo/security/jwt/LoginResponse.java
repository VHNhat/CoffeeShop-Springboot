package com.example.demo.security.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

//	private String accessToken;
//    private String tokenType = "Bearer";
//
//    public LoginResponse(String accessToken) {
//        this.accessToken = accessToken;
//    }
//
//	public String getAccessToken() {
//		return accessToken;
//	}
//
//	public void setAccessToken(String accessToken) {
//		this.accessToken = accessToken;
//	}
//
//	public String getTokenType() {
//		return tokenType;
//	}
//
//	public void setTokenType(String tokenType) {
//		this.tokenType = tokenType;
//	}
	@JsonProperty("Id")
	private long id;
	
	@JsonProperty("Username")
	private String username;
	
	@JsonProperty("Email")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.email = password;
	}

	public LoginResponse(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.email = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
    
}
