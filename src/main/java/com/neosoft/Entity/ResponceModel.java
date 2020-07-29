package com.neosoft.Entity;

import java.util.List;

public class ResponceModel{
	
	private long emp_id;
	private String username;
	private String password;
    
	//private boolean active;
	private List<EducationEntity> emp_Education;

	private List<AddressEntity> address;

	private EmpDetailEntity employee_detail;

 
	private EmploymentEntity employment_Detail;

 
	private RoleEntity employee_Role;


	private ContactsEntity  emp_contacts;

	
	public ResponceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


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

	public List<EducationEntity> getEmp_Education() {
		return emp_Education;
	}

	public void setEmp_Education(List<EducationEntity> emp_Education) {
		this.emp_Education = emp_Education;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}

	public EmpDetailEntity getEmployee_detail() {
		return employee_detail;
	}

	public void setEmployee_detail(EmpDetailEntity employee_detail) {
		this.employee_detail = employee_detail;
	}

	public EmploymentEntity getEmployment_Detail() {
		return employment_Detail;
	}

	public void setEmployment_Detail(EmploymentEntity employment_Detail) {
		this.employment_Detail = employment_Detail;
	}

	public RoleEntity getEmployee_Role() {
		return employee_Role;
	}

	public void setEmployee_Role(RoleEntity employee_Role) {
		this.employee_Role = employee_Role;
	}

	public ContactsEntity getEmp_contacts() {
		return emp_contacts;
	}

	public void setEmp_contacts(ContactsEntity emp_contacts) {
		this.emp_contacts = emp_contacts;
	}


	public ResponceModel(long emp_id, String username, String password, 
			List<EducationEntity> emp_Education, List<AddressEntity> address, EmpDetailEntity employee_detail,
			EmploymentEntity employment_Detail, RoleEntity employee_Role, ContactsEntity emp_contacts) {
		super();
		this.emp_id = emp_id;
		this.username = username;
		this.password = password;

		this.emp_Education = emp_Education;
		this.address = address;
		this.employee_detail = employee_detail;
		this.employment_Detail = employment_Detail;
		this.employee_Role = employee_Role;
		this.emp_contacts = emp_contacts;
	}

	
	
	

}
