package com.revature.models;

public abstract class Account {
	private double accountBalance;
	static private int accountNumber = 1;

	public Account() {
		super();
		this.accountBalance = 0;
		accountNumber++;
	}

	public void accountDeposit() {
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

}
