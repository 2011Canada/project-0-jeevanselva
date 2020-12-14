package com.revature.service;

import com.revature.models.Account;
import com.revature.repositories.AccountDAO;

public class AccountService {

	Account userAccount;
	AccountDAO dao;

	public AccountService() {
		this.dao = new AccountDAO();
		this.userAccount = dao.getUserAccount();
	}

	public double accountBalanceService() {
		Account account = dao.getUserAccount();
		double currentBalance = account.getAccountBalance();
		return currentBalance;
	}

	public boolean accountDepositService(double deposit) {
		boolean transaction = userAccount.accountDeposit(deposit);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			dao.accountUpdate(balance);
			return true;
		} else {
			return false;
		}
		/*
		 * if (transaction) { System.out.println("The amount of $" + deposit +
		 * " has been successfuly deposited in your account"); return true; } else {
		 * System.out.
		 * println("This was an invalid transaction! Your deposit amount has to be greater than 0"
		 * ); return false; }
		 */
	}

	public boolean accountWithdrawalService(double withdrawalAmount) {
		boolean transaction = userAccount.accountWithdrawal(withdrawalAmount);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			dao.accountUpdate(balance);
			return true;
		} else {
			return false;
		}
	}
	/*
	 * 
	 * if (transaction) { System.out.println(" A withdrawal amount of $" +
	 * withdrawalAmount + " will be dispensed!"); return true; } else {
	 * System.out.println("This was an invalid transaction!"); return false; }
	 */
}
