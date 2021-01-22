package com.projet.modules.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projet.modules.jdbc.bean.table.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer cus = new Customer();
		
		cus.setId(rs.getLong("id"));
		cus.setLastName(rs.getString("last_name"));
		cus.setFirstName(rs.getString("first_name"));
		
		return cus;
	}

}
