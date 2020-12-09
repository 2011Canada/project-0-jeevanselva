package com.revature.models;

public class Application {
	private Customer newCustomer;
	private String statusOfApplication;

	public Application(Customer newCustomer) {
		super();
		this.newCustomer = newCustomer;
		this.statusOfApplication = "pending";
	}

	@Override
	public String toString() {
		return "Application [newCustomer=" + newCustomer + ", statusOfApplication=" + statusOfApplication + "]";
	}

}
