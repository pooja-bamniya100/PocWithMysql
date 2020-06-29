package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employee_contacts;
import com.neosoft.model.Employment_Detail;

public class RequestModel {

	
	private long emp_id;
	private String username;
	private String password;
    private String confirmPassword;
	

	private boolean active;
	private List<Emp_Education> emp_Education;

	private List<Emp_Address> address;

	private Employee_Detail employee_detail;


	private Employment_Detail employment_Detail;

 
	private Employee_Role employee_Role;


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


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	
	
}
