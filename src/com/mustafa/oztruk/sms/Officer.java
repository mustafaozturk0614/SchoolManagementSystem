package com.mustafa.oztruk.sms;

import java.time.LocalDate;

public class Officer extends Employee {
	
	public Officer(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus, double salary,
			LocalDate dateOfStart) {
		super(name, gender, bitrhday, maritalStatus, salary, dateOfStart);
		this.registrationNumber = String.format("M-%03d", countEmployee);
	}
	
}
