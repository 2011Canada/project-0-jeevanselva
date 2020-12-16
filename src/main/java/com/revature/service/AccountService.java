package com.revature.service;

import java.util.ArrayList;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.CurrentUser;
import com.revature.models.ListOfAccounts;
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
		BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " checked balance of account "
				+ CurrentUser.getCurrentAccount());
		return currentBalance;
	}

	public boolean accountDepositService(double deposit) {
		boolean transaction = userAccount.accountDeposit(deposit);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			dao.accountUpdate(balance);
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " made a valid deposit in account "
					+ CurrentUser.getCurrentAccount());
			return true;
		} else {
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId()
					+ " attempted an invalid deposit in account " + CurrentUser.getCurrentAccount());
			return false;
		}

	}

	public boolean accountWithdrawalService(double withdrawalAmount) {
		boolean transaction = userAccount.accountWithdrawal(withdrawalAmount);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			BankAppLauncher.appLogger.debug("User Id: " + CurrentUser.getUserId() + " made a withdrawal in account "
					+ CurrentUser.getCurrentAccount());
			dao.accountUpdate(balance);

			return true;
		} else {
			BankAppLauncher.appLogger.debug("User Id: " + CurrentUser.getUserId()
					+ " attempted an invalid withdrawal in account " + CurrentUser.getCurrentAccount());
			return false;
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
