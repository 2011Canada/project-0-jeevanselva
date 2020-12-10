package com.revature.models;

public abstract class Account {
	private double accountBalance;
	static private int accountNumber = 1000000;

	public Account() {
		super();
		this.accountBalance = 0;
		accountNumber++;
	}

	public void accountDeposit(double deposit) {
		if (deposit <= 0) {
			System.out.println("Your deposit has to be a minimum of $1");
		}
		else {
			this.accountBalance += deposit;
		}
	}
	
	
	public double getAccountBalance() {
		return this.accountBalance;
	}
	public void setAccountBalance(double addMoney) {
		 this.accountBalance += addMoney;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
}
