package com.mustafa.oztruk.sms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	protected LocalDate startDate;
	protected List<Lecture> lectures;
	protected static int studentNumber;
	protected String registrationNumber;
	
	public Student(PersonName name, Gender gender, LocalDate bitrhday) {
		super(name, gender, bitrhday);
		studentNumber = setStudentNumber();
		this.maritalStatus = CivilStatus.SİNGLE;
		this.telephoneNumber = new int[3];
		this.lectures = new ArrayList<Lecture>();
		
	}
	
	public List<Lecture> getLectures() {
		return lectures;
	}
	
	public void addLectures(Lecture lectures) {
		this.lectures.add(lectures);
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public int setStudentNumber() {
		if (studentNumber == 999) {
			studentNumber = 1;
			
		}
		
		else {
			studentNumber++;
			
		}
		return studentNumber;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void addRegistrationNumber(LocalDate startDate) {
		registrationNumber = String.format("%04d-%03d", startDate.getYear(), studentNumber);
		this.registrationNumber = registrationNumber;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
		addRegistrationNumber(this.startDate);
	}
	
	@Override
	public void addTelephoneNumber(int telephonenumber) {
		try {
			if (this.telephoneIndex < 3) {
				this.telephoneNumber[this.telephoneIndex] = telephonenumber;
				telephoneIndex++;
				
			} else {
				System.out.println("Hatalı bir değer girdiniz");
			}
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("En fazla 2 adet telefon ekleyebilirsiniz");
		} catch (Exception e) {
			System.out.println("Hatalı bir değer girdiniz");
		}
		
	}
	
	public void printlist() {
		this.lectures.forEach(System.out::println);
		
	}
	
}
