package com.neosoft.Entity;

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


public class RoleEntity{
	
	private long employee_role_id;
	
	private String role;
//	private Employee_Master employee_Role;

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

	
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleEntity(long employee_role_id, String role) {
		super();
		this.employee_role_id = employee_role_id;
		this.role = role;
	}

}
