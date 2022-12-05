package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String state;
	private String country;
	private String BIC;
	
	public Bank() {
		super();
	}
	
	public Bank(String name, String state, String country, String bIC) {
		this.name = name;
		this.state = state;
		this.country = country;
		this.BIC = bIC;
	}
	
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", state=" + state + ", country=" + country + ", BIC=" + BIC + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		this.BIC = bIC;
	}
}
