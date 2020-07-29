package com.neosoft.controller;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.neosoft.Entity.AddressEntity;
import com.neosoft.Entity.EducationEntity;
import com.neosoft.Entity.EmpDetailEntity;
import com.neosoft.Entity.RoleEntity;
import com.neosoft.Entity.ContactsEntity;
import com.neosoft.Entity.EmploymentEntity;
import com.neosoft.Entity.RequestModel;
import com.neosoft.Entity.ResponceModel;
import com.neosoft.exception.PasswordNotMatchException;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Master;
import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employee_contacts;
import com.neosoft.model.Employment_Detail;



public abstract class EmployeeAbstractClass {
	/**
	 * 
	 *  method to create a responce 
	 *  @return responce the ResponceEntity 
	 *  @param employee_master the Employee_Master object
	 * 
	 *  */


	protected  ResponseEntity responceBuilder(Employee_Master employee_Master)
	{

		ResponceModel responce=getResponceModel(employee_Master);
		return new ResponseEntity(responce,HttpStatus.OK);


	}
	
	public Employee_Master getEmployee(RequestModel model)
	{
		Employee_contacts emp_contacts=new Employee_contacts();
		Employee_Detail employee_Detail=new Employee_Detail();
	    Employee_Role employee_role=new Employee_Role();
	     Employment_Detail employment_Detail=new Employment_Detail();
	     Emp_Address emp_Address=new Emp_Address();
	     Emp_Education emp_Education=new Emp_Education();
		
		Employee_Master employee=new Employee_Master();
		employee.setUsername(model.getUsername());
		employee.setPassword(model.getPassword());
		employee.setConfirmPassword(model.getConfirmPassword());
		
		BeanUtils.copyProperties(model.getEmp_contacts(),emp_contacts);
		BeanUtils.copyProperties(model.getEmployee_detail(),employee_Detail);
		BeanUtils.copyProperties(model.getEmployee_Role(),employee_role);
		BeanUtils.copyProperties(model.getEmployment_Detail(),employment_Detail);
		
		List<AddressEntity> add_list=model.getAddress();
		List<EducationEntity> edu_list=model.getEmp_Education();
		List<Emp_Address> emp_add_list=new ArrayList();
		List<Emp_Education> emp_edu_list=new ArrayList();
		
		for(int i=0;i<edu_list.size();i++) {
			BeanUtils.copyProperties(edu_list.get(i),emp_Education)	;
			emp_edu_list.add(emp_Education);
		}
		
		for(int i=0;i<add_list.size();i++) {
			BeanUtils.copyProperties(add_list.get(i),emp_Address)	;
			emp_add_list.add(emp_Address);
		}
		
		employee.setAddress(emp_add_list);
		employee.setEmp_contacts(emp_contacts);
		employee.setEmp_Education(emp_edu_list);
		employee.setEmployee_detail(employee_Detail);
		employee.setEmployee_Role(employee_role);
		employee.setEmployment_Detail(employment_Detail);
	
		return employee;

	}

	/**
	 * 
	 *  method to create a responce 
	 *  @return responce the ResponceEntity 
	 *  @param employee_master type of List<Employee_Master> 
	 * 
	 *  */
	protected  ResponseEntity responceBuilder(List<Employee_Master> employee_Master)
	{ 
		
		List<ResponceModel> responce=new ArrayList();
		for(int i=0;i<employee_Master.size();i++)
			responce.add(getResponceModel(employee_Master.get(i)));


		return new ResponseEntity(responce,HttpStatus.OK);


	}

	/**
	 * 
	 *  method to create a responceModel object 
	 *  @return model the ResponceModel object
	 *  @param employee_master the Employee_Master object
	 * 
	 *  */
	protected ResponceModel getResponceModel(Employee_Master employee_Master)
	{
		
       ResponceModel responce=new ResponceModel();
		
      ContactsEntity emp_contacts=new ContactsEntity();
       EmpDetailEntity employee_Detail=new EmpDetailEntity();
       RoleEntity employee_role=new RoleEntity();
      EmploymentEntity employment_Detail=new EmploymentEntity();
       AddressEntity emp_Address=new AddressEntity();
      EducationEntity emp_Education=new EducationEntity();
		
		responce.setUsername(employee_Master.getUsername());
		responce.setEmp_id(employee_Master.getEmp_id());
		responce.setPassword(employee_Master.getPassword());
		BeanUtils.copyProperties(employee_Master.getEmp_contacts(),emp_contacts);
		BeanUtils.copyProperties(employee_Master.getEmployee_detail(),employee_Detail);
		BeanUtils.copyProperties(employee_Master.getEmployee_Role(),employee_role);
		BeanUtils.copyProperties(employee_Master.getEmployment_Detail(),employment_Detail);
		
		List<Emp_Address> emp_add_list=employee_Master.getAddress();
		List<Emp_Education> emp_edu_list=employee_Master.getEmp_Education();
		List<AddressEntity> add_list=new ArrayList();
		List<EducationEntity> edu_list=new ArrayList();
		
		for(int i=0;i<emp_edu_list.size();i++) {
			BeanUtils.copyProperties(emp_edu_list.get(i),emp_Education)	;
			edu_list.add(emp_Education);
		}
		
		for(int i=0;i<emp_add_list.size();i++) {
			BeanUtils.copyProperties(emp_add_list.get(i),emp_Address)	;
			add_list.add(emp_Address);
		}
		
		responce.setAddress(add_list);
		responce.setEmp_contacts(emp_contacts);
		responce.setEmp_Education(edu_list);
		responce.setEmployee_detail(employee_Detail);
		responce.setEmployee_Role(employee_role);
		responce.setEmployment_Detail(employment_Detail);
       

		return responce;	
	}

	/**
	 * 
	 *  method to check validation for password
	 *  @param emp the type of Employee_Master
	 *  
	 *   */
	protected void validPassword(Employee_Master emp) throws PasswordNotMatchException {
		int l=emp.getPassword().length();

		if(l>16 && l<8)
			throw new PasswordNotMatchException("password lenth should in between 8 and 16");

		if(emp.getConfirmPassword().equals(emp.getPassword())) {}
		else
			throw new PasswordNotMatchException("password not match as above password");
	}

	/**
	 * 
	 *  method to check validation for contact no
	 *  @param emp the type of Employee_Master
	 *  
	 *   */

	protected void validContact(Employee_Master emp) {

		Employee_contacts employee_contacts=emp.getEmp_contacts();
		if( String.valueOf(employee_contacts.getAltername_contact() ).length()!=10) {
			if( String.valueOf(employee_contacts.getAltername_contact() ).length()!=10)

			{
				throw new ValidationException("enter 10 digit contact no");
			}
		}
	}

	/**
	 * 
	 *  method to check validation for all data
	 *  @param emp the type of Employee_Master
	 *  
	 *   */
	public void validData(Employee_Master emp)


	{  

		Employee_Detail employee_Detail=emp.getEmployee_detail();
		Employee_Role employee_Role=emp.getEmployee_Role();
		List<Emp_Address> emp_Address=emp.getAddress();
		List<Emp_Education> emp_Education=emp.getEmp_Education();
		Employment_Detail employment_Detail=emp.getEmployment_Detail();

		Date d=new Date(2020,06,25);

		if(employee_Detail.getDob().before(d)) {

		}else
			throw new ValidationException("date of birth should be past date");



		if(emp.getUsername()==null ) {
			if(employee_Detail.getFirstname()==null && employee_Detail.getDob()==null && employee_Detail.getLastname()==null)
			{
				if(employee_Role.getRole()==null)
				{
					if(emp_Address.size()==0)
					{
						if(emp_Education.size()==0) {
							throw new ValidationException("data cannot be null store any standard value");
						}
					}
				}
			}

		}

	}



}
