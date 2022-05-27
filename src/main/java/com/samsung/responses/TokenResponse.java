package com.samsung.responses;

import com.samsung.models.UserDTO;

public class TokenResponse {
	String token;
	int status;
	UserDTO user;
	public TokenResponse(String token, int status, UserDTO user) {
		this.token = token;
		this.status = status;
		this.user = user;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
