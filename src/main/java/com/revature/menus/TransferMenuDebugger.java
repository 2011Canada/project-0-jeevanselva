package com.revature.menus;

import com.revature.models.CurrentUser;
import com.revature.service.AccountService;
import com.revature.service.TransferService;

public class TransferMenuDebugger {
	public static void main(String[] args) {
		TransferService ts = new TransferService();
		CurrentUser.setUserId(5);
		AccountService as = new AccountService();
		System.out.println("ID 5 balance: ");
		System.out.println(as.accountBalanceService());
		ts.sendMoneyTransfer(300, 102);
		System.out.println("ID 5 sent 300 to ID 6");
		CurrentUser.setUserId(6);
		System.out.println("ID 6 balance: ");
		AccountService as2 = new AccountService();
		System.out.println(as2.accountBalanceService());
		TransferService ts2 = new TransferService();
		ts2.checkMoneyTransfer();
		System.out.println("ID 6 balance after money transfer: ");
		ts2.acceptMoneyTransfer(true);
		System.out.println(as2.accountBalanceService());

	}
}
