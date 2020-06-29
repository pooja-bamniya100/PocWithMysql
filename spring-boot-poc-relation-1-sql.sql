CREATE TABLE emp_address (emp_address_id BIGINT NOT NULL, created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, city VARCHAR(255) NOT NULL, country VARCHAR(255) NOT NULL, dist VARCHAR(255) NOT NULL, pincode VARCHAR(255) NOT NULL, state VARCHAR(255) NOT NULL, emp_id BIGINT, PRIMARY KEY (emp_address_id)) ENGINE=MYISAM;

CREATE TABLE emp_education (emp_education_id BIGINT NOT NULL, created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, pass_year DATE NOT NULL, perc FLOAT NOT NULL, qualification VARCHAR(255) NOT NULL, sc_name VARCHAR(255) NOT NULL, university VARCHAR(255) NOT NULL, emp_id BIGINT, PRIMARY KEY (emp_education_id)) ENGINE=MYISAM;

 CREATE TABLE employee_contacts (created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, altername_contact BIGINT NOT NULL, contact BIGINT NOT NULL, email VARCHAR(255), emp_contacts_emp_id BIGINT NOT NULL, PRIMARY KEY (emp_contacts_emp_id)) ENGINE=MYISAM;

CREATE TABLE employee_detail (created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, active BIT NOT NULL, dob DATE NOT NULL, fathers_name VARCHAR(255), firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, employee_detail_emp_id BIGINT NOT NULL, PRIMARY KEY (employee_detail_emp_id)) ENGINE=MYISAM;

 CREATE TABLE employee_master (emp_id BIGINT NOT NULL, created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, active BIT NOT NULL, PASSWORD VARCHAR(16) NOT NULL, username VARCHAR(255) NOT NULL, PRIMARY KEY (emp_id)) ENGINE=MYISAM;

CREATE TABLE employee_role (created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, role VARCHAR(255), employee_role_emp_id BIGINT NOT NULL, PRIMARY KEY (employee_role_emp_id)) ENGINE=MYISAM;

 CREATE TABLE employment_detail (created_by VARCHAR(255), created_date DATETIME, last_modified_by VARCHAR(255), last_modified_date DATETIME, experience INTEGER NOT NULL, joining_date DATE NOT NULL, previous_company VARCHAR(255) NOT NULL, salary BIGINT NOT NULL, employment_detail_emp_id BIGINT NOT NULL, PRIMARY KEY (employment_detail_emp_id)) ENGINE=MYISAM;

 CREATE TABLE hibernate_sequence (next_val BIGINT) ENGINE=MYISAM;

 INSERT INTO hibernate_sequence VALUES ( 1 );

 INSERT INTO hibernate_sequence VALUES ( 1 );

 INSERT INTO hibernate_sequence VALUES ( 1 );

 ALTER TABLE emp_address ADD CONSTRAINT FK3pf4h0jtde18qyk4ifg8fe6qc FOREIGN KEY (emp_id) REFERENCES employee_master (emp_id);

ALTER TABLE emp_education ADD CONSTRAINT FK3inewxwtrs72bcb8xi4xyp5rd FOREIGN KEY (emp_id) REFERENCES employee_master (emp_id);

ALTER TABLE employee_contacts ADD CONSTRAINT FKfgm5r9e9e9u33rhmlt0hfa36p FOREIGN KEY (emp_contacts_emp_id) REFERENCES employee_master (emp_id);

ALTER TABLE employee_detail ADD CONSTRAINT FK9amr5vuq83emh9gltchj3l8mg FOREIGN KEY (employee_detail_emp_id) REFERENCES employee_master (emp_id);

 ALTER TABLE employee_role ADD CONSTRAINT FK56hfcomx5o9q3nsyp5b4xa366 FOREIGN KEY (employee_role_emp_id) REFERENCES employee_master (emp_id);

 ALTER TABLE employment_detail ADD CONSTRAINT FK5wat0l5kx09t0uib0f2mfwvbh FOREIGN KEY (employment_detail_emp_id) REFERENCES employee_master (emp_id)employee_masteremployment_detailemployee_detailemp_education;