package com.neosoft;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatcher.*;

import com.neosoft.Entity.RequestModel;
import com.neosoft.Entity.ResponceModel;
import com.neosoft.controller.EmployeeAbstractClass;
import com.neosoft.controller.EmployeeController;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Master;
import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employee_contacts;
import com.neosoft.model.Employment_Detail;
import com.neosoft.service.EmployeeService;




public class EmployeeControllerTest extends EmployeeAbstractClass{

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		//mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

		getEmployee_Master();
		getRequestModel();

	}

	/**
	 * declare all global variable or objecs
	 */

	Employee_Master em = new Employee_Master();

	Emp_Education emp_Education = new Emp_Education();
	Emp_Address emp_Address = new Emp_Address();
	Employee_Detail employee_Detail = new Employee_Detail();
	Employment_Detail employment_Detail = new Employment_Detail();
	Employee_Role employee_Role = new  Employee_Role();;
	Employee_contacts employee_contact =  new Employee_contacts();

	List<Employee_Master> em_list = new ArrayList();
	List<Emp_Address> ed_list=new ArrayList();
	List<Emp_Education> ee_dlist =new ArrayList();

	
	com.neosoft.Entity.EducationEntity req_emp_Education = new com.neosoft.Entity.EducationEntity();
	com.neosoft.Entity.AddressEntity req_emp_Address = new com.neosoft.Entity.AddressEntity();
	com.neosoft.Entity.EmpDetailEntity req_employee_Detail = new com.neosoft.Entity.EmpDetailEntity();
	com.neosoft.Entity.EmploymentEntity req_employment_Detail = new com.neosoft.Entity.EmploymentEntity();
	com.neosoft.Entity.RoleEntity req_employee_Role = new  com.neosoft.Entity.RoleEntity();;
	com.neosoft.Entity.ContactsEntity req_employee_contact =  new com.neosoft.Entity.ContactsEntity();
	
	List<Employee_Master> req_em_list = new ArrayList();
	List<com.neosoft.Entity.AddressEntity> req_ed_list=new ArrayList();
	List<com.neosoft.Entity.EducationEntity> req_ee_dlist =new ArrayList();
	
	String searchby = null;
	Long id=10l;
	Date d = new Date(2020, 06, 18);


	/** 
	 * create model object and set all value
	 * 
	 * @return em the Employee_Master object
	 * */

	private Employee_Master getEmployee_Master()
	{

		//emp_Education = new Emp_Education(null, d, "pooja", d, 1, "bsc", "abc", "abc", 65, d, em);
		emp_Education.setPass_year(d);emp_Education.setPerc(65);emp_Education.setQualification("bsc");
		emp_Education.setSc_name("aaaa");emp_Education.setUniversity("uuuuu");
		//emp_Address = new Emp_Address(null, d, "pooja", d, 1, "office", "dhar", "dhar", "mp", "india", 232323, em);
		emp_Address.setAddType("office");emp_Address.setCity("dhar");emp_Address.setCountry("india");emp_Address.setDist("dhar");
		emp_Address.setState("mp");emp_Address.setPincode(999999);
		//employee_Detail = new Employee_Detail(null, d, "pooja", d, 1, "pooja", "gupta", "aaaaa", d, true, em);
		employee_Detail.setActive(true);employee_Detail.setFathersName("ffffff");employee_Detail.setFirstname("aaaaa");
		employee_Detail.setDob(d);employee_Detail.setLastname("lllllllll");
		//employment_Detail = new Employment_Detail(null, d, "pooja", d, 1, d, 50000, "ddddd", 5.0f,em);
		employment_Detail.setExperience(5);employment_Detail.setJoining_date(d);
		employment_Detail.setPrevious_company("ssss");employment_Detail.setSalary(50000);
		//	employee_Role = new Employee_Role(null, d, "pooja", d, 1, "admin", em);
		employee_Role.setRole("gggg");
		//employee_contact = new Employee_contacts(null, d, "pooja", d, 1, 999999999, 8888888, "sss@gmail.com", em);
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
		//		em  = new Employee_Master(null, d, null, d, 100, "poojab", "poojab", true, ee_dlist,ed_list,employee_Detail,
		//				employment_Detail, employee_Role,employee_contact);

		emp_Education.setMaster(em);     emp_Address.setMaster(em); employee_Detail.setEmployee_detail(em);
		employment_Detail.setEmployment_Detail(em); employee_Role.setEmployee_Role(em); employee_contact.setEmp_contacts(em);
		return em;
	}

	/** 
	 * create model object of RequestModel and set all value
	 * 
	 * @return em the RequestModel object
	 * */

	private RequestModel getRequestModel()
	{
		RequestModel model=new RequestModel();
		
		req_emp_Education.setPass_year(d);req_emp_Education.setPerc(65);req_emp_Education.setQualification("bsc");
		req_emp_Education.setSc_name("aaaa");req_emp_Education.setUniversity("uuuuu");
	
		req_emp_Address.setAddType("office");req_emp_Address.setCity("dhar");req_emp_Address.setCountry("india");req_emp_Address.setDist("dhar");
		req_emp_Address.setState("mp");req_emp_Address.setPincode(999999);
		req_employee_Detail.setActive(true);req_employee_Detail.setFathersName("ffffff");req_employee_Detail.setFirstname("aaaaa");
		req_employee_Detail.setDob(d);req_employee_Detail.setLastname("lllllllll");
		req_employment_Detail.setExperience(5);req_employment_Detail.setJoining_date(d);
		req_employment_Detail.setPrevious_company("ssss");req_employment_Detail.setSalary(50000);
		req_employee_Role.setRole("gggg");
		req_employee_contact.setAltername_contact(2222222222l);req_employee_contact.setContact(5555555555l);
		req_employee_contact.setEmail("ppp@gmail.com");


		req_ed_list.add(req_emp_Address);
        req_ee_dlist.add(req_emp_Education);
		//model.setActive(true);
		model.setEmp_id(100);
		model.setUsername("poojab");
		model.setPassword("000000000");
		model.setConfirmPassword("000000000");
		model.setEmp_Education(req_ee_dlist);
		model.setAddress(req_ed_list);
		model.setEmployee_detail(req_employee_Detail);
		model.setEmployment_Detail(req_employment_Detail);
		model.setEmployee_Role(req_employee_Role);
		model.setEmp_contacts(req_employee_contact);
		
		return model;
	}

	/**
	 * test to save method 
	 * 
	 */
	@Test
	public void testSaveEmployee() throws Exception {

		RequestModel model=getRequestModel();
		

		ResponseEntity responceActual=responceBuilder(em);
		when(employeeService.saveEmployee(any(Employee_Master.class))).thenReturn(em);
			ResponseEntity responceCheck= employeeController.saveEmployee(model);

		assertNotNull(responceCheck);
		ResponceModel responceActualModel=(ResponceModel) responceActual.getBody();
		ResponceModel responceCheckModel=(ResponceModel) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.getEmp_contacts().getEmail(),responceCheckModel.getEmp_contacts().getEmail());
		assertEquals(responceActualModel.getUsername(),responceCheckModel.getUsername());


	}


	/**
	 * test to select all employee
	 */
	@Test
	public void testGetEmployees() throws Exception {
		Employee_Master em2=getEmployee_Master();
		em2.setUsername("artibamniya");
		em2.setPassword("111111111");
		em2.setConfirmPassword("111111111");
		em2.getEmp_contacts().setEmail("aaa@gmail.com");
		em_list.add(em2);
		em_list.add(em);
		ResponseEntity responceActual=responceBuilder(em_list);
		when(employeeService.getEmployees()).thenReturn(em_list);
		ResponseEntity responceCheck= employeeController.getEmployees();
		assertNotNull(responceCheck);
		List<ResponceModel> responceActualModel=(List<ResponceModel>) responceActual.getBody();
		List<ResponceModel> responceCheckModel=(List<ResponceModel>) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.size(),responceCheckModel.size());
		for(int i=0;i<responceActualModel.size();i++)
			assertEquals(responceActualModel.get(i).getEmp_contacts().getEmail(),responceCheckModel.get(i).getEmp_contacts().getEmail());

	}
	/**
	 * test sorting of employee
	 */
	@Test
	public void testGetSortedEmployees()
	{
		String dob="dob",order="ascending";
		Date d1=new Date(1995, 10, 10);
		Date d2=new Date(1997, 05, 01);
		Employee_Master em2=getEmployee_Master();
		em2.setUsername("artibamniya");
		em2.setPassword("11111111111");
		em2.setConfirmPassword("11111111111");
		em2.getEmp_contacts().setEmail("aaa@gmail.com");
		em2.getEmployee_detail().setDob(d1);
		em.getEmployee_detail().setDob(d2);
		em_list.add(em2);
		em_list.add(em);
		ResponseEntity responceActual=responceBuilder(em_list);
		when(employeeService.getSortedEmployees(dob,order)).thenReturn(em_list);
		ResponseEntity responceCheck=employeeController.getAscByDob();

		assertNotNull(responceCheck);
		List<ResponceModel> responceActualModel=(List<ResponceModel>) responceActual.getBody();
		List<ResponceModel> responceCheckModel=(List<ResponceModel>) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.size(),responceCheckModel.size());
		for(int i=0;i<responceActualModel.size();i++)
			assertEquals(responceActualModel.get(i).getEmp_contacts().getEmail(),responceCheckModel.get(i).getEmp_contacts().getEmail());
	}


	/**
	 * test to search employee
	 */  
	@Test
	public void testGetemployee() throws Exception {
		searchby="pooja";
		em_list.add(em);
		ResponseEntity responceActual=responceBuilder(em_list);
		when(employeeService.getEmployee(searchby)).thenReturn(em_list);
		ResponseEntity responceCheck=employeeController.getEmployee(searchby);

		assertNotNull(responceCheck);

		List<ResponceModel> responceActualModel=(List<ResponceModel>) responceActual.getBody();
		List<ResponceModel> responceCheckModel=(List<ResponceModel>) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.size(),responceCheckModel.size());
		for(int i=0;i<responceActualModel.size();i++)
			assertEquals(responceActualModel.get(i).getEmp_contacts().getEmail(),responceCheckModel.get(i).getEmp_contacts().getEmail());
	}


	/**
	 * test to get active employee
	 * 
	 */
	@Test
	public void testGetActiveEmployee() throws Exception {
		Employee_Master em2=getEmployee_Master();
		em2.setUsername("artibamniya");
		em2.setPassword("11111111111");
		em2.setConfirmPassword("11111111111");
		em2.getEmp_contacts().setEmail("aaa@gmail.com");
		em2.setActive(true);
		em_list.add(em2);
		em_list.add(em);
		ResponseEntity responceActual=responceBuilder(em_list);
		when(employeeService.getActiveEmployee()).thenReturn(em_list);
		ResponseEntity responceCheck=employeeController.getActiveEmployee();

		assertNotNull(responceCheck);
		List<ResponceModel> responceActualModel=(List<ResponceModel>) responceActual.getBody();
		List<ResponceModel> responceCheckModel=(List<ResponceModel>) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.size(),responceCheckModel.size());
		for(int i=0;i<responceActualModel.size();i++)
			assertEquals(responceActualModel.get(i).getEmp_contacts().getEmail(),responceCheckModel.get(i).getEmp_contacts().getEmail());

	}
	/**
	 * test to get Deactivated  employee
	 */

	@Test
	public void testGetDeactiveEmployee() throws Exception {
		Employee_Master em2=getEmployee_Master();
		em2.setUsername("artibamniya");
		em2.setPassword("11111111111");
		em2.setConfirmPassword("11111111111");
		em2.getEmp_contacts().setEmail("aaa@gmail.com");
		em2.setActive(false);
		em.setActive(false);
		em_list.add(em2);
		em_list.add(em);
		ResponseEntity responceActual=responceBuilder(em_list);
		when(employeeService.getDeactiveEmployee()).thenReturn(em_list);

		ResponseEntity responceCheck=employeeController.getDeactiveEmployee();

		assertNotNull(responceCheck);
		List<ResponceModel> responceActualModel=(List<ResponceModel>) responceActual.getBody();
		List<ResponceModel> responceCheckModel=(List<ResponceModel>) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.size(),responceCheckModel.size());
		for(int i=0;i<responceActualModel.size();i++)
			assertEquals(responceActualModel.get(i).getEmp_contacts().getEmail(),responceCheckModel.get(i).getEmp_contacts().getEmail());
	}


	/**
	 * test to get employee by id
	 * 
	 * 
	 */
	@Test
	public void testgetEmployee() throws Exception {
		ResponseEntity responceActual=responceBuilder(em);
		when(employeeService.getEmployee(id)).thenReturn(em);

		ResponseEntity responceCheck=employeeController.getEmployee(id);

		assertNotNull(responceCheck);

		ResponceModel responceActualModel=(ResponceModel) responceActual.getBody();
		ResponceModel responceCheckModel=(ResponceModel) responceCheck.getBody();
		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());
		assertEquals(responceActualModel.getEmp_contacts().getEmail(),responceCheckModel.getEmp_contacts().getEmail());
		assertEquals(responceActualModel.getUsername(),responceCheckModel.getUsername());
	}
	
	/**
	 * test to update employee
	 */
	@Test
	public void testUpdateEmployee() throws Exception {
		//   Employee_Master  em2=getEmployee_Master();
		RequestModel model=getRequestModel();
		model.setPassword("11111111111");

		model.setConfirmPassword("11111111111");

		ResponseEntity responceActual=responceBuilder(em);

		when(employeeService.updateEmployee((any(Employee_Master.class)), any())).thenReturn(em);

		ResponseEntity responceCheck=employeeController.updateEmployee(model, id);

		assertNotNull(responceCheck);

		ResponceModel responceActualModel=(ResponceModel) responceActual.getBody();

		ResponceModel responceCheckModel=(ResponceModel) responceCheck.getBody();


		assertEquals(responceActual.getStatusCode(),responceCheck.getStatusCode());

		assertEquals(responceActualModel.getEmp_contacts().getEmail(),responceCheckModel.getEmp_contacts().getEmail());
		assertEquals(responceActualModel.getUsername(),responceCheckModel.getUsername());
	}


	/**
	 * test to soft delete employee or deactivate employee
	 */

	@Test
	public void testDeactivate() throws Exception {
		Employee_Master em=getEmployee_Master();
		em.setActive(false);
		String responceActual="Employee having" + id + " sucsessfully deactivated";
		when(employeeService.deactivate(id)).thenReturn(responceActual);
		ResponseEntity responceEntity=employeeController.deactivate(id);
		String respnceCheck=(String) responceEntity.getBody();
		assertEquals(responceActual,respnceCheck );
	}
	/**
	 *  test to hard delete employee
	 */
	@Test
	public void testDeleteEmployee() throws Exception {
		String responceActual="Employee" + id + " sucsessfully deleted";
		when(employeeService.deleteEmployee(id)).thenReturn(responceActual);
		ResponseEntity responceEntity=employeeController.deleteEmployee(id);
		String respnceCheck=(String) responceEntity.getBody();
		assertEquals( responceActual,respnceCheck);
	}
	//	mockMvc.perform(get("/deactivate/id")).andExpect(status().isOk());

}
