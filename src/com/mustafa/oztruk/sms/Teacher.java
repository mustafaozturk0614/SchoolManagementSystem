package com.mustafa.oztruk.sms;

import java.time.LocalDate;

public class Teacher extends Employee {
	
	public Teacher(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus, double salary,
			LocalDate dateOfStart) {
		super(name, gender, bitrhday, maritalStatus, salary, dateOfStart);
		this.telephoneNumber = new int[2];
		this.telephoneIndex = 0;
		this.registrationNumber = String.format("Ö-%03d", countEmployee);
	}
	
}