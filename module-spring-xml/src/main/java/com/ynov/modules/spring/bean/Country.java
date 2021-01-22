/**
 * 
 */
package com.ynov.modules.spring.bean;

import lombok.ToString;

/**
 * @author bilonjea
 *
 */
@ToString
public class Country {
	private String name;
	private long population;
	
	public Country(String name, long population) {
		super();
		this.name = name;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
	
}
 
