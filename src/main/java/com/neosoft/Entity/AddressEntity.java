package com.neosoft.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class AddressEntity {
	
	private long emp_address_id;
	
	private String addType;
	
	private String city;
	
	
	private String dist;

	private String state;
	

	private String country;
	
	
	private int pincode;
	
//	 public Employee_Master master;  

	 
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getEmp_address_id() {
		return emp_address_id;
	}

	public void setEmp_address_id(long emp_address_id) {
		this.emp_address_id = emp_address_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}


	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(long emp_address_id, String addType, String city, String dist, String state, String country,
			int pincode) {
		super();
		this.emp_address_id = emp_address_id;
		this.addType = addType;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	
	
	

	
	
}
