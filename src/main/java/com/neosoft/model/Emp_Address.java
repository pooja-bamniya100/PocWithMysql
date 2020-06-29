package com.neosoft.model;

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



@Entity


public class Emp_Address extends Auditable<String> {
	@Id
	@GeneratedValue
	private long emp_address_id;
	
	@NotNull
	private String addType;
	
		@NotNull
	private String city;
	
	@NotNull
	private String dist;

	@NotNull
	private String state;
	
	@NotNull
	private String country;
	
	@NotNull
	private int pincode;
	
	@JsonBackReference
	 @ManyToOne(cascade = CascadeType.REMOVE) 
	  Employee_Master master;
	  

	 
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

	
	
	 
	  
	  
	  public Employee_Master getMaster() { return master; }
	  
	  public void setMaster(Employee_Master master) { this.master = master; }

	public Emp_Address(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
			long emp_address_id, @NotNull String addType, @NotNull String city, @NotNull String dist,
			@NotNull String state, @NotNull String country, @NotNull int pincode, Employee_Master master) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.emp_address_id = emp_address_id;
		this.addType = addType;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.master = master;
	}

	public Emp_Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp_Address(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}
	 

	
	

	
	
}
