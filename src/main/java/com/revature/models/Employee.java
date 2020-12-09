package com.revature.models;

public class Employee extends Person {
	private int employeeId;

	public Employee(String firstName, String lastName, int age, String phoneNumber, String emailAddress,
			int employeeId) {
		super(firstName, lastName, age, phoneNumber, emailAddress);
		this.employeeId = employeeId;
	}

}
