/**
 * 
 */
package com.ynov.modules.spring.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ynov.modules.spring.annotation.business.MyComponent;
import com.ynov.modules.spring.annotation.config.AppConfiguration;
import com.ynov.modules.spring.annotation.lang.Language;
import com.ynov.modules.spring.annotation.lang.impl.English;
import com.ynov.modules.spring.annotation.lang.impl.Vietnamese;
import com.ynov.modules.spring.annotation.service.GreetingService;

import lombok.extern.log4j.Log4j;

/**
 * @author bilonjea
 *
 */
@Log4j
public class AppSpringAnnotationMain {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

		// Creating a Context Application object by reading
		// the configuration of the 'AppConfiguration' class.
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		log.info("----------");
		Language language = (Language) context.getBean("language");

		log.info("Bean Language: "+ language);
		log.info("Call language.sayBye(): "+ language.getBye());

		log.info("----------");

		GreetingService service = (GreetingService) context.getBean("greetingService");


		service.sayGreeting();

		log.info("----------");

		MyComponent myComponent = (MyComponent) context.getBean("myComponent");

		myComponent.showAppInfo();
		
		
		log.info("----------English-----------");
		English en = (English) context.getBean("english");
		log.info(en.getBye());
		
		
		log.info("----------Vietnamese-------");
		Vietnamese viet = (Vietnamese) context.getBean("vietnamese");
		log.info(viet.getBye());

	}

}
