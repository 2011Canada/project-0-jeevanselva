package com.revature.service;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.CurrentUser;
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
		BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " checked balance");
		return currentBalance;
	}

	public boolean accountDepositService(double deposit) {
		boolean transaction = userAccount.accountDeposit(deposit);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			dao.accountUpdate(balance);
			BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " made a valid deposit");
			return true;
		} else {
			BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " attempted invalid deposit");
			return false;
		}

	}

	public boolean accountWithdrawalService(double withdrawalAmount) {
		boolean transaction = userAccount.accountWithdrawal(withdrawalAmount);
		double balance = userAccount.getAccountBalance();
		if (transaction) {
			BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " made a withdrawal");
			dao.accountUpdate(balance);

			return true;
		} else {
			BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " attempted invalid withdrawal");
			return false;

		}
	}

}
