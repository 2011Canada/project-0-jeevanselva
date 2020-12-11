package com.revature.service;

import com.revature.models.Account;
import com.revature.repositories.AccountDAO;

public class AccountService {

	AccountDAO accountDetails;
	Account userAccount;

	public AccountService(Account userAccount) {
		this.userAccount = userAccount;
	}

	public void accountBalanceService() {
		System.out.println("Your account has a current balance of: $" + userAccount.getAccountBalance());
	}

	public boolean accountDepositService(double deposit) {
		boolean transaction = userAccount.accountDeposit(deposit);

		if (transaction) {
			System.out.println("The amount of $" + deposit + " has been successfuly deposited in your account");
			return true;
		} else {
			System.out.println("This was an invalid transaction! Your deposit amount has to be greater than 0");
			return false;
		}

	}

	public boolean accountWithdrawalService(double withdrawalAmount) {
		boolean transaction = userAccount.accountWithdrawal(withdrawalAmount);
		if (transaction) {
			System.out.println(" A withdrawal amount of $" + withdrawalAmount + " will be dispensed!");
			return true;
		} else {
			System.out.println("This was an invalid transaction!");
			return false;
		}
	}
}
