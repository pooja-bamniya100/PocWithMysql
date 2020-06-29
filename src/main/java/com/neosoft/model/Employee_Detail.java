package com.neosoft.model;

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



@Entity


public class Employee_Detail extends Auditable<String>{
	@Id
	@GeneratedValue
	private long employee_Detail_Id;
	
	@NotNull(message="firstname cant be empty")
	private String firstname;
	
	@NotNull(message="lastname cant be empty")
	private String lastname;
	
	private String fathersName;
	
	@NotNull(message="field cant be empty")
    //@Past
	private Date dob;
	
	private boolean active=true;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Employee_Master employee_detail;

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

	public Employee_Master getEmployee_detail() {
		return employee_detail;
	}

	public void setEmployee_detail(Employee_Master employee_detail) {
		this.employee_detail = employee_detail;
	}

	public Employee_Detail(String createdBy, java.util.Date createdDate, String lastModifiedBy,
			java.util.Date lastModifiedDate, long employee_Detail_Id,
			@NotNull(message = "firstname cant be empty") String firstname,
			@NotNull(message = "lastname cant be empty") String lastname, String fathersName,
			@NotNull(message = "field cant be empty") Date dob, boolean active, Employee_Master employee_detail) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.employee_Detail_Id = employee_Detail_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fathersName = fathersName;
		this.dob = dob;
		this.active = active;
		this.employee_detail = employee_detail;
	}

	public Employee_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee_Detail(String createdBy, java.util.Date createdDate, String lastModifiedBy,
			java.util.Date lastModifiedDate) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}

	
	
}
