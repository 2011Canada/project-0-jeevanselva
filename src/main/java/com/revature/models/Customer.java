package com.revature.models;

public class Customer extends Person {
	private Account myMaccount;

	public Customer(String firstName, String lastName, int age, String phoneNumber, String emailAddress,
			Account myMaccount) {
		super(firstName, lastName, age, phoneNumber, emailAddress);
		this.myMaccount = myMaccount;
	}

	public Account getAccount() {
		return this.myMaccount;
	}
}
