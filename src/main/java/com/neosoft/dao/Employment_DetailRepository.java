package com.neosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Employee_Role;
import com.neosoft.model.Employment_Detail;

@Repository
public interface Employment_DetailRepository extends JpaRepository<Employment_Detail, Long>{

}
