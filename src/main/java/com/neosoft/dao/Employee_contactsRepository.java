package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Emp_Education;
import com.neosoft.model.Employee_contacts;

@Repository
public interface Employee_contactsRepository extends JpaRepository<Employee_contacts, Long> {

}
