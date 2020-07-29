package com.neosoft.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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




public class EducationEntity  {
	
	private long emp_Education_id;

	private String qualification;

	private String sc_name;

	private String university;

	private float perc;

	private Date pass_year;

//	  Employee_Master master;
	  
	public long getEmp_Education_id() {
		return emp_Education_id;
	}

	public void setEmp_Education_id(long emp_Education_id) {
		this.emp_Education_id = emp_Education_id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSc_name() {
		return sc_name;
	}

	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public float getPerc() {
		return perc;
	}

	public void setPerc(float perc) {
		this.perc = perc;
	}

	public Date getPass_year() {
		return pass_year;
	}

	public void setPass_year(Date pass_year) {
		this.pass_year = pass_year;
	}

	
	  
	  
	public EducationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationEntity(long emp_Education_id, String qualification, String sc_name, String university, float perc,
			Date pass_year) {
		super();
		this.emp_Education_id = emp_Education_id;
		this.qualification = qualification;
		this.sc_name = sc_name;
		this.university = university;
		this.perc = perc;
		this.pass_year = pass_year;
	}



	
	  
	  
	 

}
