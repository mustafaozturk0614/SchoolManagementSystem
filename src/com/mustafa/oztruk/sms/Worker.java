package com.mustafa.oztruk.sms;

import java.time.LocalDate;

public class Worker extends Employee {
	
	public Worker(PersonName name, Gender gender, LocalDate bitrhday, CivilStatus maritalStatus, double salary,
			LocalDate dateOfStart) {
		super(name, gender, bitrhday, maritalStatus, salary, dateOfStart);
		this.registrationNumber = String.format("H-%03d", countEmployee);
	}
	
}
