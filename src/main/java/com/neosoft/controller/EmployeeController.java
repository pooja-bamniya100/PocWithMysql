package com.neosoft.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neosoft.Entity.AuthRequest;
import com.neosoft.Entity.IdOrPasswordEntity;
import com.neosoft.Entity.RequestModel;
import com.neosoft.dao.Employee_MasterRepository;
import com.neosoft.exception.PasswordNotMatchException;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.EmployeeError;
import com.neosoft.model.Employee_Master;
import com.neosoft.service.EmployeeService;
import com.neosoft.util.JwtUtil;





@RestController
//@CrossOrigin(origins="http://localhost:4200")  

@Transactional
//@RequestMapping("/employee")
public class EmployeeController extends EmployeeAbstractClass {


	@Autowired
	EmployeeService employeeService;

	
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//    	return new WebMvcConfigurer() {
//    		public void addCorsMappings(CorsRegistry registry) {
//    			
//    			registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
//    		}
//    	};
//    	
//    }
    @GetMapping("/home")
    public String home() {
        return "Welcome to javatechie !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

	/**
	 * Create Employee_Master employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 * @throws Exception 
	 */
	@PostMapping(value="/save")
	public ResponseEntity saveEmployee(@Valid @RequestBody RequestModel requestModel) throws Exception {
	    
	    		    	
	    	
//	    		    	
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
		System.out.println("hellow");
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
		System.out.println("RequestModel.username"+requestModel.getUsername());
    	System.out.println("RequestModel.pass"+requestModel.getPassword());
    	System.out.println("RequestModel.aterpassme"+requestModel.getConfirmPassword());
    	System.out.println("firstname"+requestModel.getEmployee_detail().getFirstname());
    	System.out.println("RequestModel.lastname"+requestModel.getEmployee_detail().getLastname());
    	System.out.println("RequestModel.fathername"+requestModel.getEmployee_detail().getFathersName());
    	System.out.println("RequestModel.dob"+requestModel.getEmployee_detail().getDob());
    	System.out.println("RequestModel.contact"+requestModel.getEmp_contacts().getContact());
    	System.out.println("RequestModel.altercon"+requestModel.getEmp_contacts().getAltername_contact());
    	System.out.println("RequestModel.email"+requestModel.getEmp_contacts().getEmail());
    	System.out.println("RequestModel.role"+requestModel.getEmployee_Role().getRole());
    	System.out.println("RequestModel.experience"+requestModel.getEmployment_Detail().getExperience());
    	System.out.println("RequestModel.pc"+requestModel.getEmployment_Detail().getPrevious_company());
    	System.out.println("RequestModel.join"+requestModel.getEmployment_Detail().getJoining_date());
    	System.out.println("RequestModel.salary"+requestModel.getEmployment_Detail().getSalary());
    	List<com.neosoft.Entity.AddressEntity> l=requestModel.getAddress();
    	for(int i=0;i<l.size();i++) {
    		com.neosoft.Entity.AddressEntity e=(com.neosoft.Entity.AddressEntity) l.get(i);
    	System.out.println("RequestModel.addty1"+e.getAddType());
    	System.out.println("RequestModel.city1"+e.getCity());
    	System.out.println("RequestModel.dist1"+e.getDist());
    	System.out.println("RequestModel.stat1"+e.getState());
    	System.out.println("RequestModel.cou1"+e.getCountry());
    	System.out.println("RequestModel.pinc1"+e.getPincode());
    	
    	}
    	 List<com.neosoft.Entity.EducationEntity> l1=requestModel.getEmp_Education();
    	 for(int i=0;i<l1.size();i++) {
    		 com.neosoft.Entity.EducationEntity e=(com.neosoft.Entity.EducationEntity) l1.get(i);
    		 System.out.println("RequestModel.q1"+e.getQualification());
 	    	System.out.println("RequestModel.pass"+e.getPass_year());

 	    	System.out.println("RequestModel.perc"+e.getPerc());
 	    	System.out.println("RequestModel.sc"+e.getSc_name());
 	    	System.out.println("RequestModel.uni"+e.getUniversity());
 	    	
    	 }

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
		  ResponseEntity responce=responceBuilder(employeeService.getEmployee(searchBy));

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
	 * update password
	 *
	 * @param id the employee id
	 * @return the mesage
	 * @throws ResourceNotFoundException the resource not found exception
	 * @throws PasswordNotMatchException 
	 */
	@PutMapping("/updatePass/{id}")
	public ResponseEntity updatePassword(@RequestBody  IdOrPasswordEntity idOrPasswordEntity,@PathVariable long id) throws ResourceNotFoundException, PasswordNotMatchException
	{   System.out.println("called");
		Employee_Master master=new Employee_Master();
		BeanUtils.copyProperties(idOrPasswordEntity,master)	;
		 System.out.println("master");
        validPassword(master);
        System.out.println("called"+idOrPasswordEntity.getPassword());
		ResponseEntity responce=new ResponseEntity<>(employeeService.updatePassword(id,idOrPasswordEntity),HttpStatus.OK);
		return responce;

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
