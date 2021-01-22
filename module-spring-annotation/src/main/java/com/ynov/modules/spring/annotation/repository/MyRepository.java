/**
 * 
 */
package com.ynov.modules.spring.annotation.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * @author bilonjea
 *
 */
@Repository
public class MyRepository {
 
    public String getAppName() {
        return "Hello Spring App";
    }
 
    public Date getSystemDateTime() {
        return new Date();
    }

}
