package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Emp_Address;
import com.neosoft.model.Emp_Education;

@Repository
public interface Emp_EducationRepository extends JpaRepository<Emp_Education, Long> {

}
