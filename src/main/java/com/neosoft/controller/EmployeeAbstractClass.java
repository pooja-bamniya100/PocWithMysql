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


import com.neosoft.exception.PasswordNotMatchException;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Master;
import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employee_contacts;
import com.neosoft.model.Employment_Detail;
import com.neosoft.model.ResponceModel;

import Entity.RequestModel;



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
		Employee_Master employee=new Employee_Master();
   	 BeanUtils.copyProperties(model,employee);
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
		
		String name=employee_Master.getEmployee_detail().getFirstname()+" "+employee_Master.getEmployee_detail().getLastname();
		String email=employee_Master.getEmp_contacts().getEmail();
		 String username=employee_Master.getUsername();
		List<Emp_Address> e_address=employee_Master.getAddress();
		List<Emp_Education> e_edu=employee_Master.getEmp_Education();
		List<String> address=new ArrayList();
		List<String> education=new ArrayList();
		for(int i=0;i<e_address.size();i++)
		{
			address.add(e_address.get(i).getAddType()+" : "+e_address.get(i).getCity()+" ,"+e_address.get(i).getDist()+" ,"
					+ " "+e_address.get(i).getState()+" ,"+e_address.get(i).getCountry()+" ,"+e_address.get(i).getPincode());
		}
		for(int i=0;i<e_edu.size();i++)
		{
			education.add(e_edu.get(i).getQualification()+" perc :"+e_edu.get(i).getPerc()+" pass year :"+e_edu.get(i).getPass_year());
		}
		
		 Long salary=employee_Master.getEmployment_Detail().getSalary();
	
		return new ResponceModel(name,username,address,salary,education,email);	
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
		Date d=new Date(2020,06,25);

		
		Employee_Detail employee_Detail=emp.getEmployee_detail();
		Employee_Role employee_Role=emp.getEmployee_Role();
		List<Emp_Address> emp_Address=emp.getAddress();
		List<Emp_Education> emp_Education=emp.getEmp_Education();
		Employment_Detail employment_Detail=emp.getEmployment_Detail();

		

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

	/**
	 *  to set request value
	 *  
	 *   */
	protected Employee_Master requestBuilder(RequestModel requestModel)
	{
		Employee_Master employee_Master=new Employee_Master();
		
		employee_Master.setPassword(requestModel.getPassword());
		employee_Master.setUsername(requestModel.getUsername());
		employee_Master.setConfirmPassword(requestModel.getConfirmPassword());
		employee_Master.setEmp_contacts(requestModel.getEmp_contacts());
		employee_Master.setEmployee_detail(requestModel.getEmployee_detail());
		employee_Master.setEmployee_Role(requestModel.getEmployee_Role());
		employee_Master.setEmp_Education(requestModel.getEmp_Education());
		employee_Master.setAddress(requestModel.getAddress());
		
		
		
		return employee_Master;
		
	}

}
