package com.neosoft.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neosoft.audit.Auditable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Employee_Master extends Auditable<String> {

	@Id
	@GeneratedValue
	private long emp_id;

	@NotNull(message="username cant be empty")
	@Size(min=6)
	private String username;

	@NotNull(message="password cant be empty")
	@Size(min=8,max=16)
	private String password;
	@Transient
    private String confirmPassword;
	

	private boolean active;

	@OneToMany(cascade=CascadeType.ALL) 
	@JoinColumn(name="emp_id")
	private List<Emp_Education> emp_Education;


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private List<Emp_Address> address;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee_detail")
	private Employee_Detail employee_detail;


	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employment_Detail") 
	private Employment_Detail employment_Detail;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee_Role") 
	private Employee_Role employee_Role;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "emp_contacts")
	private Employee_contacts  emp_contacts;

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Emp_Education> getEmp_Education() {
		return emp_Education;
	}

	public void setEmp_Education(List<Emp_Education> emp_Education) {
		this.emp_Education = emp_Education;
	}

	public List<Emp_Address> getAddress() {
		return address;
	}

	public void setAddress(List<Emp_Address> address) {
		this.address = address;
	}

	public Employee_Detail getEmployee_detail() {
		return employee_detail;
	}

	public void setEmployee_detail(Employee_Detail employee_detail) {
		this.employee_detail = employee_detail;
	}

	public Employment_Detail getEmployment_Detail() {
		return employment_Detail;
	}

	public void setEmployment_Detail(Employment_Detail employment_Detail) {
		this.employment_Detail = employment_Detail;
	}

	public Employee_Role getEmployee_Role() {
		return employee_Role;
	}

	public void setEmployee_Role(Employee_Role employee_Role) {
		this.employee_Role = employee_Role;
	}

	public Employee_contacts getEmp_contacts() {
		return emp_contacts;
	}

	public void setEmp_contacts(Employee_contacts emp_contacts) {
		this.emp_contacts = emp_contacts;
	}

	public Employee_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Employee_Master(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,
			long emp_id, @NotNull(message = "username cant be empty") @Size(min = 6) String username,
			@NotNull(message = "password cant be empty") @Size(min = 8, max = 16) String password, boolean active,
			List<Emp_Education> emp_Education, List<Emp_Address> address, Employee_Detail employee_detail,
			Employment_Detail employment_Detail, Employee_Role employee_Role, Employee_contacts emp_contacts) {
		super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.emp_id = emp_id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.emp_Education = emp_Education;
		this.address = address;
		this.employee_detail = employee_detail;
		this.employment_Detail = employment_Detail;
		this.employee_Role = employee_Role;
		this.emp_contacts = emp_contacts;
	}

	



}
