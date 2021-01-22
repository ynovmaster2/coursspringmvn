/**
 * 
 */
package com.ynov.modules.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.modules.spring.annotation.lang.Language;

/**
 * @author bilonjea
 *
 */
@Service
public class GreetingService {
	
	   @Autowired
	   private Language language;
	 
	   public GreetingService() {
	 
	   }
	 
	   public void sayGreeting() {
	        
	       String greeting = language.getGreeting();
	 
	       System.out.println("Greeting: " + greeting);
	   }
	 

}
