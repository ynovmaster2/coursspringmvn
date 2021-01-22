/**
 * 
 */
package com.projet.modules.jdbc.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.projet.modules.jdbc.bean.table.Comments;
import com.projet.modules.jdbc.config.AppConfiguration;
import com.projet.modules.jdbc.dao.CommentsDao;
import com.projet.modules.jdbc.dao.CustomerDao;

import lombok.extern.log4j.Log4j;

/**
 * @author bilonjea
 *
 */
@Log4j
public class MainSpringJDBC {
	
	public static void main(String[] args) {

		// Creating a Context Application object by reading
		// the configuration of the 'AppConfiguration' class.
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		//CustomerDao customer= (CustomerDao) ctx.getBean("customerDao");
		//customer.createTable();
		
		log.info("list des commentaires");
		CommentsDao cmntsDao = (CommentsDao) ctx.getBean("commentsDao");
		
		List<Comments> cmnts = cmntsDao.getAllComments();
		for (Comments cmnt : cmnts) {
			System.out.println(cmnt);
		}
		
		log.info("nombres des commentaires");
		System.out.println(cmntsDao.getNbComments());
		
		log.info("insert commentaires");
		cmntsDao.setComments();
		cmntsDao.setComments("mimi", "mimi@yahoo.fr", "http://www.mimi.com", "2009-09-14 10:33:11", "timi Summary", "mimi first comment");
		cmntsDao.setComments("picsou", "picsou@yahoo.fr", "http://www.picsou.com", new Date(), "picsou Summary", "picsou first comment");
		
		log.info("delet commentaires");
		cmntsDao.deleCommentById(19);
		cmntsDao.deleCommentByEmail("mimi@yahoo.");
		cmntsDao.deleCommentByUserId("picsou");
	}

}
