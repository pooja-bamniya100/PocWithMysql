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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class EmploymentEntity {
	
	private long emp_Detail_id;
	private Date joining_date;
	private long salary;
	private String previous_company;
	private float experience;
//	private Employee_Master employment_Detail;

	public long getEmp_Detail_id() {
		return emp_Detail_id;
	}

	public void setEmp_Detail_id(long emp_Detail_id) {
		this.emp_Detail_id = emp_Detail_id;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getPrevious_company() {
		return previous_company;
	}

	public void setPrevious_company(String previous_company) {
		this.previous_company = previous_company;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	

	public EmploymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmploymentEntity(long emp_Detail_id, Date joining_date, long salary, String previous_company,
			float experience) {
		super();
		this.emp_Detail_id = emp_Detail_id;
		this.joining_date = joining_date;
		this.salary = salary;
		this.previous_company = previous_company;
		this.experience = experience;
	}

	

	

}
