package com.revature.models;

public abstract class Account {
	private double accountBalance;
	private int accountNumber = 1000000;

	public Account() {
		super();
		this.accountBalance = 0;
		this.accountNumber++;
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
