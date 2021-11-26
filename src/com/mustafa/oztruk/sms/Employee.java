package com.mustafa.oztruk.sms;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Employee extends Person {
	
	protected double salary;
	protected LocalDate dateOfStart;
	protected LocalDate dateOfFinish;
	protected String registrationNumber;
	protected static int countEmployee;
	protected School scholl;
	
	public Employee(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus,
			int[] telephoneNumber) {
		super(name, gender, bitrhday, maritalStatus);
		
		countEmployee++;
	}
	
	public Employee(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus, double salary,
			LocalDate dateOfStart) {
		super(name, gender, bitrhday, maritalStatus);
		this.salary = salary;
		this.dateOfStart = dateOfStart;
		this.dateOfFinish = dateOfFinish;
		this.registrationNumber = registrationNumber;
		this.scholl = scholl;
		this.countEmployee = countEmployee;
		countEmployee++;
	}
	
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", dateOfStart=" + dateOfStart + ", dateOfFinish=" + dateOfFinish
				+ ", registrationNumber=" + registrationNumber + ", scholl=" + scholl + ", name=" + name + ", gender="
				+ gender + ", bitrhday=" + bitrhday + ", maritalStatus=" + maritalStatus + ", telephoneNumber="
				+ Arrays.toString(telephoneNumber) + "]";
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public LocalDate getdateOfFinish() {
		return dateOfFinish;
	}
	
	public void setdateOfFinish(LocalDate dateOfFinish) {
		this.dateOfFinish = dateOfFinish;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public School getScholl() {
		return scholl;
	}
	
	public void setScholl(School scholl) {
		this.scholl = scholl;
	}
	
	public LocalDate getDateOfStart() {
		return dateOfStart;
	}
	
	@Override
	public void addTelephoneNumber(int telephoneNumber) {
		try {
			if (this.telephoneIndex < 3) {
				this.telephoneNumber[this.telephoneIndex] = telephoneNumber;
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
}
