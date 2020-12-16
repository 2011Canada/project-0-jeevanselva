package com.revature.service;

import java.util.ArrayList;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.CurrentUser;
import com.revature.models.ListOfAccounts;
import com.revature.repositories.AccountDAO;

public class AccountService {

	AccountDAO dao;

	public AccountService() {
		this.dao = new AccountDAO();
	}

	public double accountBalanceService() {
		double currentBalance = (dao.readAccount()).getAccountBalance();
		BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " checked balance of account "
				+ CurrentUser.getCurrentAccount());
		return currentBalance;
	}

	public boolean accountDepositService(double deposit) {
		if (deposit <= 0) {
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId()
					+ " attempted an invalid deposit in account " + CurrentUser.getCurrentAccount());
			return false;
		} else {
			double currentBalance = (dao.readAccount()).getAccountBalance();
			double newBalance = currentBalance + deposit;
			dao.accountUpdate(newBalance);
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " made a valid deposit in account "
					+ CurrentUser.getCurrentAccount());
			return true;
		}

	}

	public boolean accountWithdrawalService(double withdrawalAmount) {
		double amount = withdrawalAmount;
		double currentBalance = (dao.readAccount()).getAccountBalance();
		double newBalance = currentBalance - withdrawalAmount;
		if (amount <= 0 || newBalance < 0) {
			BankAppLauncher.appLogger.debug("User Id: " + CurrentUser.getUserId()
					+ " attempted an invalid withdrawal in account " + CurrentUser.getCurrentAccount());
			return false;
		} else {

			dao.accountUpdate(newBalance);
			BankAppLauncher.appLogger.debug("User Id: " + CurrentUser.getUserId() + " made a withdrawal in account "
					+ CurrentUser.getCurrentAccount());
			return true;
		}
	}

	public boolean checkMultipleAccounts() {
		ListOfAccounts multipleAccounts = this.dao.checkMultipleAccounts();
		ArrayList<Account> accounts = (ArrayList<Account>) multipleAccounts.getAccounts();
		CurrentUser.setAccounts(accounts);
		if (accounts.size() > 1) {
			return true;
		} else {
			return false;
		}
	}

}
