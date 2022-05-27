package com.samsung.models;

public class UserDTO {
    private Long id;
    private String username;
    private boolean isAdmin;
	public UserDTO(Long id, String username, boolean isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.isAdmin = isAdmin;
	}
	public UserDTO() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}