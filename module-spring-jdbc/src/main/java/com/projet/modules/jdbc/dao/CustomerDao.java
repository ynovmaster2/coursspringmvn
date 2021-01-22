/**
 * 
 */
package com.projet.modules.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.projet.modules.jdbc.bean.table.Customer;

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
	
	
	public void selectCustomer() {
		
		log.info("Querying for customer records where first_name = 'Josh':");
	    
		 String sql = "SELECT id, first_name, last_name FROM customers WHERE first_name = ? and lastmNa= ?";
		 
		 List<Customer> rsul = jdbcTemplate.query(sql, new Object[] { "Josh", "Bill" }, new CustomerRowMapper());
		 
		 List<Customer> rsulbis = jdbcTemplate.query(sql, new CustomerRowMapper(),  "Josh", "Bill");
		 
		 
		

		
		
	
		
	}

}
