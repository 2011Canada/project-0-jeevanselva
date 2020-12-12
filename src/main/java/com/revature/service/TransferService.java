package com.revature.service;

import java.util.HashMap;

import com.revature.models.Account;

public class TransferService {
	private static HashMap<String, String> moneyTransferMap = new HashMap<String, String>();
	private Account userAccount;
	private String senderAccount;
	private double moneyTransferAmount;

	public TransferService(Account userAccount) {
		this.userAccount = userAccount;
	}

	public void acceptMoneyTransfer() {

	}

	/*
	 * The money sent will be stored on a HashMap with the key representing the
	 * account number the money is being sent to and the value contains the senders
	 * account number and the amount value separated by x(5) this way the recipient
	 * can receive details about the sender and the amount sent
	 */

	public boolean sendMoneyTransfer(double amount, String account) {
		boolean transaction = userAccount.accountWithdrawal(amount);
		String value = null;
		if (transaction) {
			System.out.println("The amount of " + amount + " will be sent to account number " + account + "!");
			String amountInString = String.valueOf(amount);
			value = ((Integer) this.userAccount.getAccountNumber()).toString() + "XXXXX" + amountInString;
			moneyTransferMap.put(account, value);
			return true;
		} else {
			System.out.println("This was an invalid transaction!");
			return false;
		}

	}

	public boolean checkMoneyTransfer() {
		String moneyTransferAmountInString = null; // just to test---> remove
		if (moneyTransferMap.containsKey(((Integer) this.userAccount.getAccountNumber()).toString())) {

			try {
				String moneyTransferInfo = moneyTransferMap
						.get(((Integer) this.userAccount.getAccountNumber()).toString());
				this.senderAccount = moneyTransferInfo.substring(0, 10);
				moneyTransferAmountInString = moneyTransferInfo.substring(15, moneyTransferInfo.length() - 1);
				this.moneyTransferAmount = Double.parseDouble(moneyTransferAmountInString);
			} catch (NumberFormatException e) {
				System.out.println("The money amount in string is: " + moneyTransferAmountInString); // --------------Remove
			}

			return true;
		} else {
			return false;
		}

	}

	public void acceptMoneyTransfer(boolean accept) {
		AccountService service = new AccountService(this.userAccount);
		if (accept == true) {
			service.accountDepositService(this.moneyTransferAmount);
		}

		/// need to implement a solution for what happens if the money transfer is
		/// declined
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public double getMoneyTransferAmount() {
		return moneyTransferAmount;
	}

}
