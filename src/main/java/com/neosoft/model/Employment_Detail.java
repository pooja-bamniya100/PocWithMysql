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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity

public class Employment_Detail extends Auditable<String> {
	@Id
	@GeneratedValue
	private long emp_Detail_id;
	
	@NotNull(message="field cant be null")
	private Date joining_date;
	
	@NotNull(message="field cant be null")
	private long salary;
	
	@NotNull(message="field cant be null")
	private String previous_company;
	
	@NotNull(message="field cant be null")
	private float experience;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	private Employee_Master employment_Detail;

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

	public Employee_Master getEmployment_Detail() {
		return employment_Detail;
	}

	public void setEmployment_Detail(Employee_Master employment_Detail) {
		this.employment_Detail = employment_Detail;
	}

	public Employment_Detail(String createdBy, java.util.Date createdDate, String lastModifiedBy,
			java.util.Date lastModifiedDate, long emp_Detail_id,
			@NotNull(message = "field cant be null") Date joining_date,
			@NotNull(message = "field cant be null") long salary,
			@NotNull(message = "field cant be null") String previous_company,
			@NotNull(message = "field cant be null") float experience, Employee_Master employment_Detail) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.emp_Detail_id = emp_Detail_id;
		this.joining_date = joining_date;
		this.salary = salary;
		this.previous_company = previous_company;
		this.experience = experience;
		this.employment_Detail = employment_Detail;
	}

	public Employment_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employment_Detail(String createdBy, java.util.Date createdDate, String lastModifiedBy,
			java.util.Date lastModifiedDate) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		// TODO Auto-generated constructor stub
	}

	

}
