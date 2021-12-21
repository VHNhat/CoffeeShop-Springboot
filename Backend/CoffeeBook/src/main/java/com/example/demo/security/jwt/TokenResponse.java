package com.example.demo.security.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

	@JsonProperty("Token")
	private String Token;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}
}
