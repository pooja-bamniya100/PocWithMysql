package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Employee_Detail;
import com.neosoft.model.Employee_Role;

@Repository
public interface Employee_RoleRepository extends JpaRepository<Employee_Role, Long>{

}
