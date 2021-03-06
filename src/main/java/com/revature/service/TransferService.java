package com.revature.service;

import java.util.HashMap;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.CurrentUser;
import com.revature.repositories.TransferDAO;

public class TransferService {
	private static HashMap<String, String> moneyTransferMap = new HashMap<String, String>();
	AccountService accountService;
	TransferDAO transferDao;
	private int senderAccount;
	private double moneyTransferAmount;

	public TransferService() {
		this.transferDao = new TransferDAO();
		this.accountService = new AccountService();
	}

	public int getSenderAccount() {
		return senderAccount;
	}

	public double getMoneyTransferAmount() {
		return moneyTransferAmount;
	}

	/*
	 * The money sent will be stored on a HashMap with the key representing the
	 * account number the money is being sent to and the value contains the senders
	 * account number and the amount value separated by x(5) this way the recipient
	 * can receive details about the sender and the amount sent
	 */

	public boolean sendMoneyTransfer(String amount, String account) {
		double amountInDouble = Double.parseDouble(amount);
		boolean transaction = accountService.accountWithdrawalService(amountInDouble);
		String value = null;
		if (transaction) {
			value = ((Integer) CurrentUser.getCurrentAccount()).toString() + "XXXXX" + amount;
			moneyTransferMap.put(account, value);
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " sent valid money transfer");
			return true;
		} else {
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " attempted invalid money transfer");
			return false;
		}

	}

	public boolean checkMoneyTransfer() {
		String moneyTransferAmountInString = null;
		if (moneyTransferMap.containsKey(((Integer) CurrentUser.getCurrentAccount()).toString())) {

			String moneyTransferInfo = moneyTransferMap.get(((Integer) CurrentUser.getCurrentAccount()).toString());
			String senderAccountInString = moneyTransferInfo.substring(0, 3);
			senderAccount = Integer.parseInt(senderAccountInString);
			moneyTransferAmountInString = moneyTransferInfo.substring(8, moneyTransferInfo.length() - 1);
			this.moneyTransferAmount = Double.parseDouble(moneyTransferAmountInString);
			return true;
		} else {
			return false;
		}

	}

	public void acceptMoneyTransfer(boolean accept) {
		AccountService service = new AccountService();
		if (accept == true) {
			service.accountDepositService(this.moneyTransferAmount);
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " accepted money transfer");
		} else {
			double senderBalance = transferDao.readAnotherAccount(this.senderAccount);
			senderBalance += this.moneyTransferAmount;
			transferDao.updateAnotherAccount(this.senderAccount, senderBalance);
			BankAppLauncher.appLogger.info("User Id: " + CurrentUser.getUserId() + " declined money transfer");
		}
		String myAccount = ((Integer) CurrentUser.getCurrentAccount()).toString();
		moneyTransferMap.remove(myAccount);

	}

}
