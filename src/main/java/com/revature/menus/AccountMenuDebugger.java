package com.revature.menus;

import java.util.HashMap;

import com.revature.models.CurrentUser;
import com.revature.service.AccountService;
import com.revature.service.TransferService;

public class AccountMenuDebugger {

	public static void main(String[] args) {
		TransferService ts = new TransferService();
		AccountService as = new AccountService();
		/*
		 * CurrentUser.setUserId(10); CurrentUser.setCurrentAccount(102);
		 * as.accountDepositService(1000);
		 * System.out.println(as.accountBalanceService()); ts.sendMoneyTransfer("623",
		 * "103");
		 * 
		 * TransferService ts2 = new TransferService();
		 * 
		 * CurrentUser.setUserId(10); CurrentUser.setCurrentAccount(103); boolean
		 * recieved = ts2.checkMoneyTransfer(); System.out.println(recieved);
		 * System.out.println(ts.getSenderAccount());
		 * System.out.println(ts.getMoneyTransferAmount());
		 */
		HashMap<String, String> moneyTransferMap = new HashMap<String, String>();
		String account = "105";
		String amount = "134.00";
		CurrentUser.setCurrentAccount(103);
		String value = ((Integer) CurrentUser.getCurrentAccount()).toString() + "XXXXX" + amount;
		moneyTransferMap.put(account, value);
		String moneyTransferInfo = moneyTransferMap.get("105");
		String senderAccountInString = moneyTransferInfo.substring(0, 3);
		// int senderAccount = Integer.parseInt(senderAccountInString);
		String moneyTransferAmountInString = moneyTransferInfo.substring(8, moneyTransferInfo.length() - 1);
		// double moneyTransferAmount = Double.parseDouble(moneyTransferAmountInString);

		System.out.println("Value in Map: " + value);
		System.out.println("Sender account: " + senderAccountInString);
		System.out.println("money amount in string: " + moneyTransferAmountInString);
		// System.out.println("amount in double" + moneyTransferAmount);

	}
}
