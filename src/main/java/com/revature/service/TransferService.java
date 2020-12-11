package com.revature.service;

import java.util.HashMap;

import com.revature.models.Account;

public class TransferService {
	private static HashMap<String, String> moneyTransferMap = new HashMap<String, String>();
	private Account userAccount;
	private AccountService accountService = new AccountService(userAccount);

	public TransferService(Account userAccount) {
		this.userAccount = userAccount;
	}

	public void acceptMoneyTransfer() {
		System.out.println("Your account has a current balance of: $" + userAccount.getAccountBalance());
	}

	/*
	 * The money sent will be stored on a HashMap with the key representing the
	 * account number the money is being sent to and the value contains the senders
	 * account number and the amount value separated by 3 x's
	 */

	public boolean sendMoneyTransfer(double amount, String account) {
		boolean transaction = userAccount.accountWithdrawal(amount);
		String value = null;
		if (transaction) {
			System.out.println("The amount of " + amount + " will be sent to account number " + account + "!");
			String amountInString = String.valueOf(amount);
			value = ((Integer) this.userAccount.getAccountNumber()).toString() + "XXX" + amountInString;
			moneyTransferMap.put(account, value);
			return true;
		} else {
			System.out.println("This was an invalid transaction!");
			return false;
		}

		/// need to check if the account exists*

	}

	public boolean checkMoneyTransfer() {
		return false;
	}

	public boolean getMoneyTransfer(double withdrawalAmount) {
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
