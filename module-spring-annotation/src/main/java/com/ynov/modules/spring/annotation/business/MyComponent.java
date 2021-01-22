/**
 * 
 */
package com.ynov.modules.spring.annotation.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ynov.modules.spring.annotation.repository.MyRepository;

/**
 * @author bilonjea
 *
 */
@Component
public class MyComponent {
    
    @Autowired
    private MyRepository repository;
 
    public void showAppInfo() {
        System.out.println("Now is: "+ repository.getSystemDateTime());
        System.out.println("App Name: "+ repository.getAppName());
    }

}
