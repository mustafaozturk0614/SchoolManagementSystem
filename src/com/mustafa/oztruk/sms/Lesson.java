package com.mustafa.oztruk.sms;

public enum Lesson {
	
	MATH(1, "matematik"), HISTORY(2, "tarih"), LITERATURE(3, "edebiyat"), SCIENCE(4, "fen");
	
	private int id;
	private final String name;
	
	Lesson(int id, String name) {
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
