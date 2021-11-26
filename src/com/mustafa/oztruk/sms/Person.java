package com.mustafa.oztruk.sms;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Person {
	protected PersonName name;
	protected Gender gender;
	protected LocalDate bitrhday;
	protected CivilStatus maritalStatus;
	protected int[] telephoneNumber;
	protected int telephoneIndex;
	
	public Person(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus) {
		super();
		this.name = name;
		this.gender = gender;
		this.bitrhday = bitrhday;
		this.maritalStatus = maritalStatus;
		this.telephoneNumber = new int[2];
	}
	
	public Person(PersonName name, Gender gender, LocalDate bitrhday) {
		super();
		this.name = name;
		this.gender = gender;
		this.bitrhday = bitrhday;
		this.maritalStatus = maritalStatus;
		this.telephoneNumber = new int[2];
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", bitrhday=" + bitrhday + ", maritalStatus="
				+ maritalStatus + ", telephoneNumber=" + Arrays.toString(telephoneNumber) + "]";
	}
	
	public PersonName getName() {
		return name;
	}
	
	public void setName(PersonName name) {
		this.name = name;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public CivilStatus getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(CivilStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public int[] getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(int[] telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	public LocalDate getBitrhday() {
		return bitrhday;
	}
	
	public int getTelephoneIndex() {
		return telephoneIndex;
	}
	
	public void setTelephoneIndex(int telephoneIndex) {
		this.telephoneIndex = telephoneIndex;
	}
	
	public abstract void addTelephoneNumber(int telephonenumber);
	
}
