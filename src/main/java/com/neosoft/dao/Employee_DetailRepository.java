package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_contacts;

@Repository
public interface Employee_DetailRepository extends JpaRepository<Employee_Detail, Long>{

}
