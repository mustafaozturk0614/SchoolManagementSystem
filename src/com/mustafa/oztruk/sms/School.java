package com.mustafa.oztruk.sms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class School {
	
	protected String schoolName;
	protected String adress;
	protected HashMap<String, Teacher> teachers;
	protected HashMap<String, Student> sutudents;
	protected HashMap<String, Worker> workers;
	protected HashMap<String, Officer> officers;
	protected List<Employee> employees;
	protected HashMap<Enum<Lesson>, Lecture> lectures;
	
	public School() {
		this.teachers = new LinkedHashMap<String, Teacher>();
		this.sutudents = new LinkedHashMap<String, Student>();
		this.workers = new LinkedHashMap<String, Worker>();
		this.officers = new LinkedHashMap<String, Officer>();
		this.employees = new ArrayList<Employee>();
		this.lectures = new LinkedHashMap<Enum<Lesson>, Lecture>();
		
	}
	
	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", adress=" + adress + ", teachers=" + teachers + ", sutudents="
				+ sutudents + ", workers=" + workers + ", officers=" + officers + ", employees=" + employees + "]";
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public HashMap<String, Teacher> getTeachers() {
		return this.teachers;
	}
	
	public void setTeachers(HashMap<String, Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public HashMap<String, Student> getSutudents() {
		return this.sutudents;
	}
	
	public void setSutudents(HashMap<String, Student> sutudents) {
		this.sutudents = sutudents;
	}
	
	public HashMap<String, Worker> getWorkers() {
		return workers;
	}
	
	public void setWorkers(HashMap<String, Worker> workers) {
		this.workers = workers;
	}
	
	public HashMap<String, Officer> getOfficers() {
		return officers;
	}
	
	public void setOfficers(HashMap<String, Officer> officers) {
		this.officers = officers;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public HashMap<Enum<Lesson>, Lecture> getLectures() {
		return lectures;
	}
	
	public void setLectures(HashMap<Enum<Lesson>, Lecture> lectures) {
		this.lectures = lectures;
	}
	
}
