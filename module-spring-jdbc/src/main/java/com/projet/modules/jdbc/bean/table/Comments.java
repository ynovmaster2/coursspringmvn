/**
 * 
 */
package com.projet.modules.jdbc.bean.table;

import java.util.Date;

import lombok.Data;

/**
 * @author bilonjea
 *
 */
@Data
public class Comments {
	
	private int id;
	private String myuser;
	private String email;
	private String webPage;
	private Date datum;
	private String summary;
	private String comments;
	
	

}
