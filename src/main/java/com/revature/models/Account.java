package com.revature.models;

public abstract class Account {
	private double accountBalance;
	private static int accountCounter = 1000000000;
	private int accountNumber;

	public Account() {
		super();
		this.accountBalance = 0;
		accountCounter++;
		this.accountNumber = accountCounter + 1;
	}

	public boolean accountDeposit(double deposit) {
		if (deposit <= 0) {
			return false;
		} else {
			this.accountBalance += deposit;
			return true;
		}
	}

	public boolean accountWithdrawal(double withdrawalAmount) {
		if (this.getAccountBalance() - withdrawalAmount < 0) {
			return false;
		} else {
			double balance = this.getAccountBalance() - withdrawalAmount;
			this.setAccountBalance(balance);
			return true;
		}
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(double addMoney) {
		this.accountBalance = addMoney;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

}
