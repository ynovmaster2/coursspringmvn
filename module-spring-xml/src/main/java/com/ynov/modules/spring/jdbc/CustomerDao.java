/**
 * 
 */
package com.ynov.modules.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j;

/**
 * @author bilonjea
 *
 */
@Repository
@Log4j
public class CustomerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void createTable() {
		log.info("create table");
		String query= "CREATE TABLE Customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))";
		jdbcTemplate.execute(query);
	}

}
