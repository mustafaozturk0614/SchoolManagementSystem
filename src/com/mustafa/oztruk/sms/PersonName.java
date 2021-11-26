package com.mustafa.oztruk.sms;

public class PersonName {
	private String name;
	private String surName;
	private String middleName;
	
	public PersonName() {
		// TODO Auto-generated constructor stub
	}
	
	public PersonName(String name, String surName) {
		super();
		this.name = name;
		this.surName = surName;
		this.middleName = "";
	}
	
	public PersonName(String name, String surName, String middleName) {
		super();
		this.name = name;
		this.surName = surName;
		this.middleName = middleName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", surName=" + surName + ", middleName=" + middleName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
}
