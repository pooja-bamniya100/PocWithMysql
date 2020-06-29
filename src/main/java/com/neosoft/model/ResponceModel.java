package com.neosoft.model;

import java.util.List;

public class ResponceModel{
	
         
	private String name;
	private String username;
	private List<String> address;
	private Long salary;
	private List<String> education;
	private String email;
	
	public ResponceModel(String name, String username, List<String> address, Long salary, List<String> education,String email) {
		super();
		this.name = name;
		this.username = username;
		this.address = address;
		this.salary = salary;
		this.education = education;
		this.email=email;
	}

	public String getName() {
		return name;
	}

	
	public String getUsername() {
		return username;
	}

	

	public List<String> getAddress() {
		return address;
	}

	
	public Long getSalary() {
		return salary;
	}

	

	public List<String> getEducation() {
		return education;
	}

	

	public ResponceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	
	

	
	
	

}
