create database portal_db;

/* User entity */
create table jp_usrentity(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrname VARCHAR(30) NOT NULL,
jpf_usrfname VARCHAR(30) NOT NULL, 
jpf_usrlname VARCHAR(30) NOT NULL, 
jpf_usrcrspndce_email VARCHAR(200) NOT NULL, 
jpf_usrtype INT NOT NULL, 
jpf_usrpasskey VARCHAR(25) NOT NULL, 
jpf_state varchar(2),
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p));
		
create table jp_roles(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_role_name varchar(20) NOT NULL, 
jpf_role_code varchar(5) NOT NULL, 
jpf_role_desc varchar(200),
PRIMARY KEY (jpf_id_p)) ;

/*Country Table*/		
create table jp_countries(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_code VARCHAR(3) NOT NULL, 
jpf_name VARCHAR(50) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*State Table*/
create table jp_states(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_country_id int NOT NULL, 
jpf_code VARCHAR(3) NOT NULL, 
jpf_name VARCHAR(50) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_country_id) REFERENCES jp_countries(jpf_id_p));


/*Cities Table*/
create table jp_cities(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_country_id int NOT NULL, 
jpf_state_id int NOT NULL, 
jpf_code VARCHAR(3) NOT NULL,
jpf_name VARCHAR(50) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_country_id) REFERENCES jp_countries(jpf_id_p),
FOREIGN KEY (jpf_state_id) REFERENCES jp_states(jpf_id_p));


/*Qualification Discipline */
create table jp_qualificationdisc(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(30) NOT NULL, 
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_isengineering tinyint(1) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Catagory Table*/
create table jp_catagories(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(30) NOT NULL, 
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Technology Table*/
create table jp_technologies(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(30) NOT NULL, 
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Designation Table*/
create table jp_designations(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(30) NOT NULL, 
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Language Table*/
create table jp_languages(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(30) NOT NULL, 
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Salary Table*/
create table jp_salaryscale(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_min VARCHAR(30) NOT NULL, 
jpf_max VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));

/*Status Table*/
create table jp_status(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));


/*Address table*/
create table jp_addresses(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, /*foreign key to jp_usrentity.id field */
jpf_primaryphone VARCHAR(15) NOT NULL,
jpf_secondryphone VARCHAR(15),
jpf_fax VARCHAR(11),
jpf_crspndce_email VARCHAR(200) NOT NULL, 
jpf_communication_addrs VARCHAR(200), 
jpf_permanent_addrs VARCHAR(200), 
jpf_city_id int, 
jpf_state_id int, 
jpf_country_id int, 
jpf_entitytype VARCHAR(2),
jpf_website_link VARCHAR(200), 
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p), 
FOREIGN KEY (jpf_city_id) REFERENCES jp_cities(jpf_id_p),
FOREIGN KEY (jpf_state_id) REFERENCES jp_states(jpf_id_p),
FOREIGN KEY (jpf_country_id) REFERENCES jp_countries(jpf_id_p));

/*Colleges Table*/
create table jp_colleges(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(100) NOT NULL,
jpf_code VARCHAR(5) NOT NULL,
jpf_addrs_id int, 
jpf_pointofcontact VARCHAR(100),
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_addrs_id) REFERENCES jp_addresses(jpf_id_p));


/*School Table*/
create table jp_schools(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(100) NOT NULL,
jpf_code VARCHAR(5) NOT NULL,
jpf_addrs_id int, 
jpf_pointofcontact VARCHAR(100), 
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_addrs_id) REFERENCES jp_addresses(jpf_id_p));



/*Qualification Table*/
create table jp_qualification(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, /*foreign key to jp_usrentity.id field */
jpf_ssc_school_id int,
jpf_ssc_percent decimal(10,2),
jpf_ssc_displ_id int,
jpf_hsc_school_id int,
jpf_hsc_percent decimal(10,2),
jpf_hsc_displ_id int,
jpf_grad_colg_id int,
jpf_grad_percent decimal(10,2),
jpf_grad_cgpa decimal(10,2),
jpf_grad_displ_id int,
jpf_post_grad_colg_id int,
jpf_post_grad_percent decimal(10,2),
jpf_post_grad_cgpa decimal(10,2),
jpf_post_grad_displ_id int,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p), 
FOREIGN KEY (jpf_ssc_school_id) REFERENCES jp_schools(jpf_id_p), 
FOREIGN KEY (jpf_ssc_displ_id) REFERENCES jp_qualificationdisc(jpf_id_p), 
FOREIGN KEY (jpf_hsc_school_id) REFERENCES jp_schools(jpf_id_p), 
FOREIGN KEY (jpf_hsc_displ_id) REFERENCES jp_qualificationdisc(jpf_id_p), 
FOREIGN KEY (jpf_grad_colg_id) REFERENCES jp_colleges(jpf_id_p), 
FOREIGN KEY (jpf_grad_displ_id) REFERENCES jp_qualificationdisc(jpf_id_p), 
FOREIGN KEY (jpf_post_grad_colg_id) REFERENCES jp_colleges(jpf_id_p), 
FOREIGN KEY (jpf_post_grad_displ_id) REFERENCES jp_qualificationdisc(jpf_id_p));


/*Industry Type table*/
create table jp_industrytype(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_name VARCHAR(100),
jpf_desc VARCHAR(100),
jpf_code VARCHAR(5) NOT NULL,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p));




/* Vacancy Table */
create table jp_vacancies(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, /*foreign key to jp_usrentity.id field */
jpf_catag_id int,
jpf_technology_string VARCHAR(200), /* technologyID1-MonthsOfExp1|technologyID2-MonthsOfExp2 => for example: 1-24|4-36|...  */
jpf_desc VARCHAR(254),
jpf_announcement_date DATETIME,
jpf_type VARCHAR(10),
jdp_designation_id int,
jpf_availfrom DATETIME,
jpf_availto DATETIME,
jpf_expctd_min_exp smallint, /*in months*/
jpf_expctd_max_exp smallint, /*in months*/
jpf_location_address_id int,
jpf_qualification_id int,
jpf_expctd_min_sal int, 
jpf_expctd_max_sal int,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL,
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p),
FOREIGN KEY (jpf_catag_id) REFERENCES jp_catagories(jpf_id_p),
FOREIGN KEY (jdp_designation_id) REFERENCES jp_designations(jpf_id_p),
FOREIGN KEY (jpf_location_address_id) REFERENCES jp_addresses(jpf_id_p),
FOREIGN KEY (jpf_qualification_id) REFERENCES jp_qualification(jpf_id_p));


/* Company entity  */
create table jp_compnyentity(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, 
jpf_industrytype_id int NOT NULL, 
jpf_addrs_id int,
jpf_cname VARCHAR(200) NOT NULL, 
jpf_comptype VARCHAR(2) NOT NULL, 
jpf_noofemps int NOT NULL,
jpf_avgjobpermonth smallint NOT NULL, 
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p),
FOREIGN KEY (jpf_industrytype_id) REFERENCES jp_industrytype(jpf_id_p));



/* consultancy table */
create table jp_consultancy(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, 
jpf_industrytype_id int, 
jpf_name VARCHAR(200) NOT NULL, 
jpf_addrs_id int,
jpf_noofemps int,
jpf_avgjobpermonth smallint, 
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p),
FOREIGN KEY (jpf_industrytype_id) REFERENCES jp_industrytype(jpf_id_p));

/* Talent entity */
create table jp_talententity(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, /*foreign key to jp_usrentity.id field */
jpf_dob DATETIME NOT NULL, 
jpf_gndr VARCHAR(2) NOT NULL, 
jpf_summary VARCHAR(100),
jpf_technology_string VARCHAR(200), 
jpf_reslink TEXT, 
jpf_experience smallint, /* in months*/
jpf_curaddrss_id int,  /*foreign key to address.id table */
jpf_permaddrss_id int,  /*foreign key to address.id table */
jpf_curemployer_id int, /* foreign key to employer.id table*/
jpf_designtion_id int,  /* foreign key to designation table*/
jpf_preemployer_id int, /* foreign key to employer.id field*/
jpf_catag_id int, /*foreign key to catagory.id field*/
jpf_prefcatag_id_1 int NOT NULL,  /* foreign key to preference.id field*/
jpf_prefcatag_id_2 int,  /* foreign key to preference.id field*/
jpf_lang_id_1 int NOT NULL,  /* foreign key to language.id field*/
jpf_lang_id_2 int,  /* foreign key to language.id field*/
jpf_lang_id_3 int, /* foreign key to language.id field*/
jpf_cursal_scale_id int,  /* foreign key to salaryslab.id field*/ 
jpf_expcdsal_scale_id int,  /* foreign key to salaryslab.id field*/
jpf_ref_id int,  /* foreign key to  reference.id field*/
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p), 
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p),
FOREIGN KEY (jpf_curaddrss_id) REFERENCES jp_addresses(jpf_id_p),
FOREIGN KEY (jpf_permaddrss_id) REFERENCES jp_addresses(jpf_id_p),
FOREIGN KEY (jpf_curemployer_id) REFERENCES jp_compnyentity(jpf_id_p),
FOREIGN KEY (jpf_designtion_id) REFERENCES jp_designations(jpf_id_p),
FOREIGN KEY (jpf_preemployer_id) REFERENCES jp_compnyentity(jpf_id_p),
FOREIGN KEY (jpf_catag_id) REFERENCES jp_catagories(jpf_id_p),
FOREIGN KEY (jpf_prefcatag_id_1) REFERENCES jp_catagories(jpf_id_p),
FOREIGN KEY (jpf_prefcatag_id_2) REFERENCES jp_catagories(jpf_id_p),
FOREIGN KEY (jpf_lang_id_1) REFERENCES jp_languages(jpf_id_p),
FOREIGN KEY (jpf_lang_id_2) REFERENCES jp_languages(jpf_id_p),
FOREIGN KEY (jpf_lang_id_3) REFERENCES jp_languages(jpf_id_p),
FOREIGN KEY (jpf_cursal_scale_id) REFERENCES jp_salaryscale(jpf_id_p),
FOREIGN KEY (jpf_expcdsal_scale_id) REFERENCES jp_salaryscale(jpf_id_p),
FOREIGN KEY (jpf_ref_id) REFERENCES jp_usrentity(jpf_id_p));


/* Recruiters table */
create table jp_recruiters(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_usrentity_id int NOT NULL, 
jpf_addrs_id int,
jpf_employer_id int, 
jpf_consultancy_id int,
jpf_designtion_id int, 
jpf_nooftalents_assigned int,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_id_p) REFERENCES jp_usrentity(jpf_id_p),
FOREIGN KEY (jpf_addrs_id) REFERENCES jp_addresses(jpf_id_p),
FOREIGN KEY (jpf_designtion_id) REFERENCES jp_designations(jpf_id_p),
FOREIGN KEY (jpf_employer_id) REFERENCES jp_compnyentity(jpf_id_p),
FOREIGN KEY (jpf_consultancy_id) REFERENCES jp_consultancy(jpf_id_p));


/* Process table */
create table jp_process(
jpf_id_p int NOT NULL AUTO_INCREMENT, 
jpf_talententity_id int NOT NULL, 
jpf_status_id int,
jpf_employer_id int, 
jpf_consultancy_id int,
jpf_date_creation DATETIME NOT NULL,
jpf_date_modified DATETIME NOT NULL, 
PRIMARY KEY (jpf_id_p),
FOREIGN KEY (jpf_talententity_id) REFERENCES jp_talententity(jpf_id_p),
FOREIGN KEY (jpf_status_id) REFERENCES jp_status(jpf_id_p),
FOREIGN KEY (jpf_employer_id) REFERENCES jp_compnyentity(jpf_id_p),
FOREIGN KEY (jpf_consultancy_id) REFERENCES jp_consultancy(jpf_id_p));
