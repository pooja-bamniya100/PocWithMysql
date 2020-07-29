package com.neosoft.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class EmpDetailEntity{
	
	private long employee_Detail_Id;

	private String firstname;
	private String lastname;
	
	private String fathersName;
	private Date dob;
	
	private boolean active=true;
//	private Employee_Master employee_detail;

	public long getEmployee_Detail_Id() {
		return employee_Detail_Id;
	}

	public void setEmployee_Detail_Id(long employee_Detail_Id) {
		this.employee_Detail_Id = employee_Detail_Id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public EmpDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpDetailEntity(long employee_Detail_Id, String firstname, String lastname, String fathersName, Date dob,
			boolean active) {
		super();
		this.employee_Detail_Id = employee_Detail_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fathersName = fathersName;
		this.dob = dob;
		this.active = active;
	}

	

	
	
}
