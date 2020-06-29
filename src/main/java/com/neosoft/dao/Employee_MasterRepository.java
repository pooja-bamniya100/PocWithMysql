package com.neosoft.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Employee_Master;





@Repository
public interface Employee_MasterRepository extends JpaRepository<Employee_Master, Long> {

	/*
	 * search employee by lastname or firstname or pincode
	 * 
	 * @param searchBy the search by given value
	 * 
	 * @return list the employee list
	 */

	@Query(value=" SELECT * FROM employee_master em WHERE em.emp_id IN(SELECT eadd.emp_id FROM emp_address eadd WHERE eadd.pincode=?1)"+
			"OR em.emp_id IN(SELECT ed.employee_detail_emp_id FROM employee_detail ed WHERE ed.firstname=?1 or lastname=?1)"+ 
			"",nativeQuery = true)
	List<Employee_Master> findByFirstNameOrLastNamePincode(Object searchBy);


	/*
	 * sort the employee by dob in ascending
	 * 
	 * @return sorted list ascending
	 */
	@Query("select em from Employee_Master em order by  employee_detail.dob asc")
	List<Employee_Master> sortByDobAsc();

	/*
	 * sort the employee by dob in descending
	 * 
	 * @return sorted list descending
	 */
	@Query("select em from Employee_Master em order by  employee_detail.dob desc")
	List<Employee_Master> sortByDobDsc();

	/*
	 * sort the employee by dateofjoiniing in ascending
	 * @return sorted list ascending
	 */
	@Query("select em from Employee_Master em order by  employment_Detail.joining_date asc")
	List<Employee_Master> sortByDateOfJoinAsc( );

	/*
	 * sort the employee by dateofjoiniing in descending
	 * 
	 * @return sorted list descending
	 */
	@Query("select em from Employee_Master em order by  employment_Detail.joining_date desc")
	List<Employee_Master> sortByDateOfJoinDsc();

	/*
	 * search employee by status
	 * 
	 * @param staus the status active or not
	 * 
	 * @return list the list of active no deactive employee
	 */
	@Query("select em from Employee_Master em where em.active=?1")
	List<Employee_Master> findAllByStatus(boolean status);





}
