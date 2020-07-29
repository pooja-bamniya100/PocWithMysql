package com.neosoft.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.neosoft.Entity.IdOrPasswordEntity;
import com.neosoft.dao.Emp_AddressRepository;
import com.neosoft.dao.Employee_MasterRepository;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Master;
import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employee_contacts;
import com.neosoft.model.Employment_Detail;

@Service
public class EmployeeService implements  UserDetailsService{

	@Autowired
	Employee_MasterRepository employee_MasterRepository;

	@Autowired
	Emp_AddressRepository emp_AddressRepository;

	/**
	 * .override method of UserDetailsService
	 *
	 * @param username the employee username
	 * @return the User
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee_Master employee = employee_MasterRepository.findByUsername(username);
		if(employee==null)
			throw new UsernameNotFoundException("User Not Found with username: " + username);
        return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), new ArrayList<>());
	}
	
	/**
	 * Create Employee_Master employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 */
	public Employee_Master saveEmployee(@Valid Employee_Master employee) {

		employee.getEmployee_detail().setEmployee_detail(employee);
		employee.getEmployee_Role().setEmployee_Role(employee);
		employee.getEmployment_Detail().setEmployment_Detail(employee);
		employee.getEmp_contacts().setEmp_contacts(employee);
		employee.getEmp_Education().forEach(e -> e.setMaster(employee));
		employee.getAddress().forEach(e -> e.setMaster(employee));

		employee.setActive(true);
		employee.getEmployee_detail().setActive(true);

		return employee_MasterRepository.save(employee);

	}

	/**
	 * Delete Employee 
	 *
	 * @param id the employee id
	 * @return the message
	 * @throws ExceptResourceNotFoundExceptionion the exception
	 */

	public String deleteEmployee(Long id) throws ResourceNotFoundException {
		Employee_Master existingEmployee = employee_MasterRepository.findById(id).orElse(null);
		if (existingEmployee == null)
			throw new ResourceNotFoundException("Employee not found having " + id);
		else {

		employee_MasterRepository.deleteById(id);
		}
		return "Employee" + id + " sucsessfully deleted";
	}

	/**
	 * deactivate the employee
	 * 
	 * @param id the employee id
	 * 
	 * @return the deavtive employee
	 * 
	 * @throws ExceptResourceNotFoundExceptionion the exception
	 */

	public String  deactivate(Long id) throws ResourceNotFoundException {
		Employee_Master existingEmployee = employee_MasterRepository.findById(id).orElse(null);
		if (existingEmployee == null)
			throw new ResourceNotFoundException("Employee not found having " + id);
		else {

			existingEmployee.setActive(false);
             employee_MasterRepository.save(existingEmployee);
		}
		return "Employee having" + id + " sucsessfully deactivated";
	}


	
	/**
	sorting based on dob or date of joining
	@param orderBy order by acsending or descending
	 *@param sortBy sort by dob or dateOfjoin
	 * @return the list
	 */
	public List<Employee_Master> getSortedEmployees(String sortBy, String orderBy) {
		List<Employee_Master> list = null;

		if (sortBy.equals("dob") && orderBy.equals("ascending"))
			list = employee_MasterRepository.sortByDobAsc();

		else if (sortBy.equals("dob") && orderBy.equals("descending"))
			list = employee_MasterRepository.sortByDobDsc();

		else if (sortBy.equals("dateOfJoin") && orderBy.equals("ascending"))
			list = employee_MasterRepository.sortByDateOfJoinAsc();

		else if (sortBy.equals("dateOfJoin") && orderBy.equals("descending"))
			list = employee_MasterRepository.sortByDateOfJoinDsc();

		for (Employee_Master e : list)
			System.out.println("dob" + e.getEmployee_detail().getDob());
		return list;

	}
	/**
	 * Get all search employee .
	 * 
	 *@param searchBy search by firstname or lastmane or pincode
	 * @return the list
	 */


	public List<Employee_Master> getEmployee(Object searchBy) throws ResourceNotFoundException {

		List<Employee_Master> list = list = employee_MasterRepository.findByFirstNameOrLastNamePincode(searchBy);
		if (list.isEmpty())
			throw new ResourceNotFoundException("Employee not found ha ving " + searchBy);
		else
			return list;

	}

	/**
	 * Get all Employee list.
	 *
	 * @return the list
	 */

	public List<Employee_Master> getEmployees() {
		List<Employee_Master> list = list = employee_MasterRepository.findAll();
		return list;

	}
	/**
	 * Gets Employee by id.
	 *
	 * @param id the employee id
	 * @return the Employee by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Employee_Master getEmployee(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee_Master emp = employee_MasterRepository.findById(id).orElse(null);
		if (emp == null)
			throw new ResourceNotFoundException("Employee not found having id" + id);
		else {
			return emp;
		}
	}
	/**
	 * Gets Employee by status.
	 *
	 * @return the active employee
	 */
	public List<Employee_Master> getActiveEmployee() {
		// TODO Auto-generated method stub
		return employee_MasterRepository.findAllByStatus(true);
	}

	/**
	 * Gets Employee by status.
	 *
	 * @return the Deactive employee
	 */
	public List<Employee_Master> getDeactiveEmployee() {
		// TODO Auto-generated method stub
		return employee_MasterRepository.findAllByStatus(false);
	}

	/**
	 * Update Employee_master entity.
	 * 
	 * @param employee the Employee_Master details
	 * @return the Employee_Master entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Employee_Master updateEmployee(Employee_Master employee,Long id) throws ResourceNotFoundException {
		Employee_Master existingEmployee = null;

		existingEmployee = employee_MasterRepository.findById(id).orElse(null);
		if (existingEmployee == null)
			throw new ResourceNotFoundException("Employee not found having id" + id);
		else {

			existingEmployee.setEmp_id(id);

			
			
			Employee_contacts emp_contact=employee.getEmp_contacts();
			Employee_contacts emp_cont=existingEmployee.getEmp_contacts();
			System.out.println(emp_contact.getAltername_contact());
			
			
			emp_contact.setEmployee_contacts_id(emp_cont.getEmployee_contacts_id());
			List<Emp_Address>  emp_Address=employee.getAddress();
			List<Emp_Address>  emp_Add=existingEmployee.getAddress();
			
			List<Emp_Education> emp_Education = employee.getEmp_Education();
			List<Emp_Education> emp_Edu=existingEmployee.getEmp_Education();
			
			Employee_Detail employee_Detail=employee.getEmployee_detail();
			Employee_Detail employee_Det=existingEmployee.getEmployee_detail();
			employee_Detail.setEmployee_Detail_Id(employee_Det.getEmployee_Detail_Id());
			
			Employee_Role employee_Role=employee.getEmployee_Role();
			Employee_Role employee_Rol=existingEmployee.getEmployee_Role();
			employee_Role.setEmployee_role_id(employee_Rol.getEmployee_role_id());
			
			Employment_Detail employment_Detail=employee.getEmployment_Detail();
			Employment_Detail employ=existingEmployee.getEmployment_Detail();
			employment_Detail.setEmp_Detail_id(employ.getEmp_Detail_id());
			
			
			for(int i=0;i<emp_Edu.size();i++) {
				emp_Education.get(i).setEmp_Education_id(emp_Edu.get(i).getEmp_Education_id());
				emp_Education.get(i).setMaster(employee);
			}
			for(int i=0;i<emp_Add.size();i++){
				emp_Address.get(i).setEmp_address_id(emp_Add.get(i).getEmp_address_id());
				emp_Address.get(i).setMaster(employee);
			}
			
			  employee_Detail.setEmployee_detail(employee);
			  emp_contact.setEmp_contacts(employee);
			  employee_Role.setEmployee_Role(employee);
			  employment_Detail.setEmployment_Detail(employee);
			  existingEmployee.setAddress(emp_Address);
			  existingEmployee.setEmp_contacts(emp_contact);
			  existingEmployee.setEmp_Education(emp_Education);
			  existingEmployee.setEmployee_detail(employee_Detail);
			  existingEmployee.setEmployee_Role(employee_Role);
			  existingEmployee.setEmployment_Detail(employment_Detail);
			  existingEmployee.setEmp_Education(emp_Education);
			return employee_MasterRepository.save(existingEmployee);
			
		
		}
	}

	/**
	 * Update Employee_master password.
	 * 
	 * @param idOrPasswordEntity the IdOrPasswordEntity having new password
	 * @return the string value
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String updatePassword(long id,IdOrPasswordEntity idOrPasswordEntity) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee_Master existingEmployee = null;

		existingEmployee = employee_MasterRepository.findById(id).orElse(null);
		if (existingEmployee == null)
			throw new ResourceNotFoundException("Employee not found having id" + id);
		else {
			
			if(existingEmployee.getEmp_contacts().getEmail().equals(idOrPasswordEntity.getEmail()))
			{
			    if(existingEmployee.getPassword() ==idOrPasswordEntity.getPassword())    
				      employee_MasterRepository.updatePassword(idOrPasswordEntity.getPassword(),existingEmployee.getEmp_id());
			
				else
					return  "Your current password not correct";
			} 
			else
				return "Your email id not correct";

		}
				return "password  successfully updated";
	
	}

}
