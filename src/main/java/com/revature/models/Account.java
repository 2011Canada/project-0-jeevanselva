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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + "]";
	}

}
