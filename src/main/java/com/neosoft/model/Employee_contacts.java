package com.neosoft.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity


public class Employee_contacts extends Auditable<String>{
	@Id
	@GeneratedValue
	//@GenericGenerator(strategy="foreign", name = "fg" ,parameters = @Pa(name="property", value = "employee_Master" ))
	private long employee_contacts_id;
	
	
	
	
  @NotNull
	private long contact;
	
  @NotNull
  
	private long altername_contact;
	
	@Email
	@NotNull(message="email cannot be null")
	private String email;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Employee_Master emp_contacts;

	public long getEmployee_contacts_id() {
		return employee_contacts_id;
	}

	public void setEmployee_contacts_id(long employee_contacts_id) {
		this.employee_contacts_id = employee_contacts_id;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public long getAltername_contact() {
		return altername_contact;
	}

	public void setAltername_contact(long altername_contact) {
		this.altername_contact = altername_contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee_Master getEmp_contacts() {
		return emp_contacts;
	}

	public void setEmp_contacts(Employee_Master emp_contacts) {
		this.emp_contacts = emp_contacts;
	}

	public Employee_contacts(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
			long employee_contacts_id, @NotNull long contact, @NotNull long altername_contact,
			@Email @NotNull(message = "email cannot be null") String email, Employee_Master emp_contacts) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.employee_contacts_id = employee_contacts_id;
		this.contact = contact;
		this.altername_contact = altername_contact;
		this.email = email;
		this.emp_contacts = emp_contacts;
	}

	public Employee_contacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee_contacts(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}

	

}
