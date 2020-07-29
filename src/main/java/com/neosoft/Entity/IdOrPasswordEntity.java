package com.neosoft.Entity;

public class IdOrPasswordEntity {

	private String password;
	private String confirmPassword;
	private String currentPassword;
	private String email;
	
	
	public IdOrPasswordEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getCurrentPassword() {
		return currentPassword;
	}


	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public IdOrPasswordEntity(String password, String confirmPassword, String currentPassword, String email) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.currentPassword = currentPassword;
		this.email = email;
	}
	
	
}
