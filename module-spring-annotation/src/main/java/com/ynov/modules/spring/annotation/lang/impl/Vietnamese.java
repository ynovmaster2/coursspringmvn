/**
 * 
 */
package com.ynov.modules.spring.annotation.lang.impl;

import org.springframework.stereotype.Component;

import com.ynov.modules.spring.annotation.lang.Language;

/**
 * @author bilonjea
 *
 */
@Component
public class Vietnamese implements Language {

	@Override
	public String getGreeting() {
		return "Xin Chao";
	}

	@Override
	public String getBye() {
		return "Tam Biet";
	}

}
