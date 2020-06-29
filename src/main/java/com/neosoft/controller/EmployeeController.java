package com.neosoft.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.dao.Employee_MasterRepository;
import com.neosoft.exception.PasswordNotMatchException;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.EmployeeError;
import com.neosoft.model.Employee_Master;
import com.neosoft.service.EmployeeService;

import Entity.RequestModel;


@RestController
@Transactional
@RequestMapping("/employee")
public class EmployeeController extends EmployeeAbstractClass {


	@Autowired
	EmployeeService employeeService;


	/**
	 * Create Employee_Master employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 * @throws Exception 
	 */
	@PostMapping(value="/save")
	public ResponseEntity saveEmployee(@Valid @RequestBody RequestModel requestModel) throws Exception {
	    
	    	
		    ResponseEntity<Object> responce =null;
		    Employee_Master employee =getEmployee(requestModel);
            validContact(employee);
	        validPassword(employee);
	        validData(employee);
	        responce= responceBuilder(employeeService.saveEmployee(employee));
            
	         
	 
		       return responce;
	}

	/**
	 * Delete Employee 
	 *
	 * @param id the employee id
	 * @return the message
	 * @throws ResourceNotFoundException 
	 * @throws ExceptResourceNotFoundExceptionion the exception
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException 
	{
		ResponseEntity responce=new ResponseEntity( employeeService.deleteEmployee(id),HttpStatus.OK);
		
		return responce;


	}

	/**deactivate the employee
	 * 
	 @param id the employee id
	 * @return the deavtive employee
	 * @throws ExceptResourceNotFoundExceptionion the exception
	 */

	@DeleteMapping("/deactivate/{id}")
	public ResponseEntity deactivate(@PathVariable Long id) throws ResourceNotFoundException
	{
        ResponseEntity responce=new ResponseEntity(  employeeService.deactivate(id),HttpStatus.OK);
		
		return responce;  


	}
	/**
	 * Update Employee details
	 *
	 * @param employee the employee
	 * @return the employee
	 * @throws ResourceNotFoundException the resource not found exception
	 * @throws PasswordNotMatchException 
	 */
	@PutMapping("/update/{id}")
	public  ResponseEntity updateEmployee(@RequestBody  RequestModel requestModel,@PathVariable long id) throws ResourceNotFoundException, PasswordNotMatchException
	{
     
		 ResponseEntity responce =null;
		 Employee_Master employee =getEmployee(requestModel);
         validContact(employee);
		 validData(employee);
         validPassword(employee);
         responce= responceBuilder(employeeService.updateEmployee(employee,id));
        
	    

		return  responce;


	}
	
	/**
	 * Get all search employee .
	 * 
	 *@param searchBy search by firstname or lastmane or pincode
	 * @return the list
	 */
	@GetMapping("/search/{searchBy}") 
	public ResponseEntity getEmployee(@PathVariable ("searchBy") Object  searchBy)
			throws ResourceNotFoundException 
	{ 
		  ResponseEntity responce=responceBuilder(  employeeService.getEmployee(searchBy));

		return responce;

	}

	/**
	 * Get all Employee list.
	 *
	 * @return the list
	 */

	@GetMapping("/findAll")
	public ResponseEntity getEmployees()
	{

		return responceBuilder(employeeService.getEmployees());

	}
	/**
	 * Gets Employee by id.
	 *
	 * @param id the employee id
	 * @return the Employee by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/findById/{id}")
	public ResponseEntity getEmployee(@PathVariable Long id) throws ResourceNotFoundException
	{
	

		return responceBuilder(employeeService.getEmployee(id));

	}

	/**
	 * Gets Employee by status.
	 *
	 * @return the active employee
	 */
	@GetMapping("/findAllActives")
	public ResponseEntity getActiveEmployee() throws ResourceNotFoundException
	{

		return responceBuilder(employeeService.getActiveEmployee());

	}

	/**
	 * Gets Employee by status.
	 *
	 * @return the Deactive employee
	 */
	@GetMapping("/findAllDeactives")
	public ResponseEntity getDeactiveEmployee()
	{

		return responceBuilder(employeeService.getDeactiveEmployee());

	}
	
	
	/**
	 * Get all Employee sorted list .
	 * by dateofbirth in ascending order
	 * 
	 * @return the list
	 */
	@GetMapping("/sortascbyDob")
	public ResponseEntity getAscByDob()
	{
		
		System.out.println("hellow");
		return responceBuilder(employeeService.getSortedEmployees("dob","ascending"));
	}
	
	
	/**
	 * Get all Employee sorted list .
	 *  by dateofbirth in descending order
	 *  
	 * @return the list
	 */
	@GetMapping("/sortdescbyDob")
	public ResponseEntity getDescByDob()
	{
				System.out.println("hellow");
		return responceBuilder(employeeService.getSortedEmployees("dob","descending"));
	}
	
	
	/**
	 * Get all Employee sorted list .
	 *orderBy order by acsending 
	sortBy dateOfjoin
	
	 * @return the list
	 */
	@GetMapping("/sortascbyJoindate")
	public ResponseEntity getAscByJoinDate()
	{
		System.out.println("hellow");
		return responceBuilder(employeeService.getSortedEmployees("dateOfJoin","ascending"));
	}
	
	
	/**
	 * Get all Employee sorted list .
	 *  orderBy ascending and sortBy dateOfjoin
	 *  
	 * @return the list
	 */
	@GetMapping("/sortdescbyJoinDate")
	public ResponseEntity getDescByJoinDate()
	{
		
		System.out.println("hellow");
		return responceBuilder(employeeService.getSortedEmployees("dateOfJoin","descending"));
	}
}
