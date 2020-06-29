package com.neosoft.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity


public class Employee_Role extends Auditable<String> {
	@Id
	@GeneratedValue
	private long employee_role_id;
	
	private String role;
	
    @JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Employee_Master employee_Role;

	public long getEmployee_role_id() {
		return employee_role_id;
	}

	public void setEmployee_role_id(long employee_role_id) {
		this.employee_role_id = employee_role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee_Master getEmployee_Role() {
		return employee_Role;
	}

	public void setEmployee_Role(Employee_Master employee_Role) {
		this.employee_Role = employee_Role;
	}

	public Employee_Role(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
			long employee_role_id, String role, Employee_Master employee_Role) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.employee_role_id = employee_role_id;
		this.role = role;
		this.employee_Role = employee_Role;
	}

	public Employee_Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee_Role(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}

	
	
}
