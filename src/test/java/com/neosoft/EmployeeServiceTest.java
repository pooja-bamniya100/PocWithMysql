package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.neosoft.controller.EmployeeController;
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
import com.neosoft.service.EmployeeService;

/**
 * 
 * 
 * It also not executable
 * 
 * */

public class EmployeeServiceTest {
	@Mock
	Employee_MasterRepository employee_MasterRepository;

	@InjectMocks
	private EmployeeService employeeService;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
				
		getEmployee_Master();
		
	}
	
	/** 
	 * declare all object or variable
	 *  */
    Employee_Master em = new Employee_Master();;
    Emp_Education emp_Education = new Emp_Education();;
    Emp_Address emp_Address = new Emp_Address();;
    Employee_Detail employee_Detail = new Employee_Detail();;
    Employment_Detail employment_Detail = new Employment_Detail();;
    Employee_Role employee_Role = new  Employee_Role();;
	Employee_contacts employee_contact =  new Employee_contacts();;

	List<Employee_Master> em_list = new ArrayList();
	List<Emp_Address> ed_list=new ArrayList();
	List<Emp_Education> ee_dlist =new ArrayList();
	
	String searchby = null;
	Long id=100l;
	Date d = new Date(2020, 06, 18);
	
	
	/** 
	 * create model object and set all value
	 * 
	 * @return em the Employee_Master object
	 * */
	private Employee_Master getEmployee_Master()
	{
		
		emp_Education.setPass_year(d);emp_Education.setPerc(65);emp_Education.setQualification("bsc");
		emp_Education.setSc_name("aaaa");emp_Education.setUniversity("uuuuu");
		
		emp_Address.setAddType("office");emp_Address.setCity("dhar");emp_Address.setCountry("india");emp_Address.setDist("dhar");
		emp_Address.setState("mp");emp_Address.setPincode(999999);
		
		employee_Detail.setActive(true);employee_Detail.setFathersName("ffffff");employee_Detail.setFirstname("aaaaa");
		employee_Detail.setDob(d);employee_Detail.setLastname("lllllllll");
		
		employment_Detail.setExperience(5);employment_Detail.setJoining_date(d);
		employment_Detail.setPrevious_company("ssss");employment_Detail.setSalary(50000);
	
		employee_Role.setRole("gggg");
		
		employee_contact.setAltername_contact(2222222222l);employee_contact.setContact(5555555555l);
		employee_contact.setEmail("ppp@gmail.com");
		
	
		ed_list.add(emp_Address);
	
		ee_dlist.add(emp_Education);
		em.setActive(true);
		em.setEmp_id(100);
		em.setUsername("poojab");
		em.setPassword("000000000");
		em.setConfirmPassword("000000000");
		em.setEmp_Education(ee_dlist);
		em.setAddress(ed_list);
		em.setEmployee_detail(employee_Detail);
		em.setEmployment_Detail(employment_Detail);
		em.setEmployee_Role(employee_Role);
		em.setEmp_contacts(employee_contact);

		
		emp_Education.setMaster(em);     emp_Address.setMaster(em); employee_Detail.setEmployee_detail(em);
		employment_Detail.setEmployment_Detail(em); employee_Role.setEmployee_Role(em); employee_contact.setEmp_contacts(em);
		return em;
	}
	
	
		/**
		 * test to save method 
		 */
	@Test
	public void testSaveEmployee() throws Exception {	
		
		when(employee_MasterRepository.save(em)).thenReturn(em);
	  
		Employee_Master em1= employeeService.saveEmployee(em);
		assertNotNull(em1);
		assertEquals(em,em1);
	}

	/**
	 * test to select all employee
	 */
		@Test
		public void testGetEmployees() throws Exception {
			Employee_Master em2=getEmployee_Master();
			em2.setUsername("artibamniya");
			em2.setPassword("1111111111");
			em2.setConfirmPassword("1111111111");
			em2.getEmp_contacts().setEmail("aaa@gmail.com");
			em_list.add(em2);
			em_list.add(em);
			when(employee_MasterRepository.findAll()).thenReturn(em_list);
			List<Employee_Master> em_list1= employeeService.getEmployees();
			assertNotNull(em_list1);
			assertEquals(em_list.size(),em_list1.size());
			for(int i=0;i<em_list1.size();i++)
			     assertEquals(em_list.get(i).getEmp_contacts().getEmail(),em_list1.get(i).getEmp_contacts().getEmail());
	
		} 
		
		/**
		 * test to get all sorted employee based on dob
          */
		@Test
		public void testGetSortedEmployees()
		{
			String dob="dob",order="ascending";
			Date d1=new Date(1995, 10, 10);
			Date d2=new Date(1997, 05, 01);
			Employee_Master em2=getEmployee_Master();
			em2.setUsername("artibamniya");
			em2.setPassword("1111111111");
			em2.setConfirmPassword("1111111111");
			em2.getEmp_contacts().setEmail("aaa@gmail.com");
			em2.getEmployee_detail().setDob(d1);
			em.getEmployee_detail().setDob(d2);
			em_list.add(em2);
			em_list.add(em);
			when(employee_MasterRepository.sortByDobAsc()).thenReturn(em_list);
	
	       List<Employee_Master> em_list1=employeeService.getSortedEmployees(dob,order);
			
	    	assertNotNull(em_list1);
			assertEquals(em_list.size(), em_list1.size());
			for(int i=0;i<em_list1.size();i++)
			     assertEquals(em_list.get(i).getEmp_contacts().getEmail(),em_list1.get(i).getEmp_contacts().getEmail());
		}
		
		

		/**
		 * test to search employee
		 */  
		@Test
			public void testGetemployee() throws Exception {
		    	searchby="pooja";
				
				em_list.add(em);
			    	when(employee_MasterRepository.findByFirstNameOrLastNamePincode(searchby)).thenReturn(em_list);
			    	List<Employee_Master> em_list1=employeeService.getEmployee(searchby);
				
			    	assertNotNull(em_list1);
				assertEquals(em_list.size(), em_list1.size());
				for(int i=0;i<em_list1.size();i++)
				     assertEquals(em_list.get(i).getEmp_contacts().getEmail(),em_list1.get(i).getEmp_contacts().getEmail());
			}
			
		
		
		/**
		 * test to get active employee
		 * 
		 */
		@Test
		public void testGetActiveEmployee() throws Exception {
			Employee_Master em2=getEmployee_Master();
			em2.setUsername("artibamniya");
			em2.setPassword("1111111111");
		em2.setConfirmPassword("1111111111");
			em2.getEmp_contacts().setEmail("aaa@gmail.com");
			em2.setActive(true);
			em_list.add(em2);
			em_list.add(em);
			when(employee_MasterRepository.findAllByStatus(true)).thenReturn(em_list);
			List<Employee_Master> em_list1=employeeService.getActiveEmployee();
			
	    	assertNotNull(em_list1);
			assertEquals(em_list.size(),em_list1.size());
			for(int i=0;i<em_list1.size();i++)
			     assertEquals(em_list.get(i).getEmp_contacts().getEmail(),em_list1.get(i).getEmp_contacts().getEmail());
	
		}
		

		/**
		 * test to get Deactivated  employee
		 * assertion fail
		 */
	   
		@Test
		public void testGetDeactiveEmployee() throws Exception {
			Employee_Master em2=getEmployee_Master();
			em2.setUsername("artibamniya");
			em2.setPassword("1111111111");
		em2.setConfirmPassword("1111111111");
			em2.getEmp_contacts().setEmail("aaa@gmail.com");
			em2.setActive(false);
			em.setActive(false);
			em_list.add(em2);
			em_list.add(em);
			when(employee_MasterRepository.findAllByStatus(false)).thenReturn(em_list);
	
	       List<Employee_Master> em_list1= employeeService.getDeactiveEmployee();
			
	    	assertNotNull(em_list1);
			assertEquals(em_list.size(), em_list1.size());
			for(int i=0;i<em_list1.size();i++)
			     assertEquals(em_list.get(i).getEmp_contacts().getEmail(),em_list1.get(i).getEmp_contacts().getEmail());
		}

		
		/**
		 * test to get employee by id
		 * 
		 * 
		 */
			@Test
			public void testgetEmployee() throws Exception {
//				Optional<Employee_Master> em1;
//				
//				Employee_Master em2=getEmployee_Master();
//				em2.setUsername("artibamniya");
//				em2.setPassword("1111111111");
//	        	em2.setConfirmPassword("1111111111");
//				em2.getEmp_contacts().setEmail("aaa@gmail.com");
//				em2.setActive(true);
//				em2.setEmp_id(101);
				
				
				when(employee_MasterRepository.findById(id)).thenReturn(Optional.of(em));
				Employee_Master em1=employeeService.getEmployee(id);
				assertEquals(em,em1);
			}
		/**
		 * test to update employee
		 */
	@Test
	public void testUpdateEmployee() throws Exception {
	
	    id=100l;
	    Employee_Master em2=getEmployee_Master();
		em2.setPassword("1111111111");
		em2.setConfirmPassword("1111111111");
		
		when(employee_MasterRepository.findById(id)).thenReturn(Optional.of(em));
		when(employee_MasterRepository.save(em2)).thenReturn(em2);
		Employee_Master em1=employeeService.updateEmployee(em2,id);
		assertNotNull(em1);
		
		assertEquals(em,em1);
	}
		/**
		 * test to soft delete employee or deactivate employee
		 * 
		 */
		@Test
		public void testDeactivate() throws Exception {
			Employee_Master em1=getEmployee_Master();
			em1.setEmp_id(100);
			
			id=100l;
			String responceActual="Employee having" + id + " sucsessfully deactivated";

			when(employee_MasterRepository.findById(id)).thenReturn(Optional.of(em));
			em1.setActive(false);
			when(employee_MasterRepository.save(em1)).thenReturn(em1);
			String responce=employeeService.deactivate(id);
			assertEquals(responceActual,responce);
		}

		/**
		 *  test to hard delete employee
		 */
		
		  @Test 
		  public void testDeleteEmployee() throws Exception {
			  
			      em=getEmployee_Master();
			      String responceActual="Employee" + id + " sucsessfully deleted";
			      when(employee_MasterRepository.findById(id)).thenReturn(Optional.of(em));
			       doNothing().when(employee_MasterRepository).deleteById(id);
			      String responce= employeeService.deleteEmployee(id);
					
					 assertEquals(responceActual,responce);
			
			    //  doReturn(responceActual).when(employee_MasterRepository).deleteById(id);
				 // org.junit.Assert.assertFalse(employee_MasterRepository.existsById(em.getEmp_id()));
					// verify(employee_MasterRepository).deleteById(id);
				 
		  }

}
