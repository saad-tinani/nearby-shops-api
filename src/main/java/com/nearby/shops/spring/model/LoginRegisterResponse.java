package com.nearby.shops.spring.model;

public class LoginRegisterResponse {
	
	private boolean status;
	private User user;
	
	public LoginRegisterResponse(boolean status, User user) {
		super();
		this.status = status;
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
