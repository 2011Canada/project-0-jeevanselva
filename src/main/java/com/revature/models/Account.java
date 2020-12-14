package com.revature.models;

public class Account {
	private int userId;
	private double accountBalance;
	private static int accountCounter = 100;
	private int accountNumber;

	public Account() {
		super();
		this.accountBalance = 0;
		accountCounter++;
		this.accountNumber = accountCounter + 1;
		this.userId = CurrentUser.getUserId();
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAccountBalance(double addMoney) {
		this.accountBalance = addMoney;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountNumber;
		return result;
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + ", accountBalance=" + accountBalance + ", accountNumber=" + accountNumber
				+ "]";
	}

}
