package com.neosoft.Entity;

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




public class ContactsEntity{
	
	private long employee_contacts_id;
	private long contact;
	private long altername_contact;
	private String email;
	//private Employee_Master emp_contacts;

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

	

	public ContactsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactsEntity(long employee_contacts_id, long contact, long altername_contact, String email) {
		super();
		this.employee_contacts_id = employee_contacts_id;
		this.contact = contact;
		this.altername_contact = altername_contact;
		this.email = email;
	}



}
