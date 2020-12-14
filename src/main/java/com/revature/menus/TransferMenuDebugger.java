package com.revature.menus;

import com.revature.models.CurrentUser;
import com.revature.service.AccountService;
import com.revature.service.TransferService;

public class TransferMenuDebugger {
	public static void main(String[] args) {
		CurrentUser.setUserId(5);
		TransferService ts = new TransferService();
		AccountService as = new AccountService();
		as.accountDepositService(500);
		System.out.println("ID 5 balance: ");
		System.out.println("intial balance: " + as.accountBalanceService());
		ts.sendMoneyTransfer(321, 102);
		AccountService as2 = new AccountService();
		System.out.println("new balance is: " + as2.accountBalanceService());

		System.out.println("ID 5 sent 321 to ID 6");
		CurrentUser.setUserId(6);
		System.out.println("ID 6 balance: ");
		AccountService as61 = new AccountService();
		System.out.println(as61.accountBalanceService());
		TransferService ts6 = new TransferService();
		ts6.checkMoneyTransfer();
		System.out.println("ID 6 balance after money transfer: ");
		ts6.acceptMoneyTransfer(false);
		AccountService as62 = new AccountService();
		System.out.println(as62.accountBalanceService());
		CurrentUser.setUserId(5);
		System.out.println("ID 5 new balance is after ID6 declined: " + as2.accountBalanceService());

	}
}
