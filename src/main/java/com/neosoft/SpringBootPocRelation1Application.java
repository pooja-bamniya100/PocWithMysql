package com.neosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.neosoft.dao.Emp_AddressRepository;
import com.neosoft.dao.Employee_MasterRepository;
import com.neosoft.model.Employee_Master;
import com.neosoft.model.Employee_Role;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootPocRelation1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocRelation1Application.class, args);

	}

	

}
