package com.mustafa.oztruk.sms;

public enum Days {
	MONDAY(1, "pazartesi"), TUESDAY(2, "salı"), WEDNESDAY(3, "çarşamba"), THURSDAY(4, "perşembe"), FRİDAY(5, "cuma"),;
	
	private final String name;
	private int id;
	
	Days(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
}