package com.revature.menus;

import java.util.ArrayList;

import com.revature.factory.MenuFactory;
import com.revature.models.Account;
import com.revature.models.CurrentUser;
import com.revature.service.AccountService;
import com.revature.service.LogoutService;

public class CustomerMenu extends Menu {
	AccountService accountService = new AccountService();
	ArrayList<Account> accounts;

	@Override
	public void displayMenu() {
		System.out.println();
		System.out.println("Choose your account: ");
		accountService.checkMultipleAccounts();
		accounts = (ArrayList<Account>) CurrentUser.getAccounts();
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			System.out.println((i + 1) + ". " + account.getType() + " Account Number: " + account.getAccountNumber());
		}
		System.out.println("Press 0 to logout");
	}

	// assuming customer is only allowed to have a maximum of 2 accounts
	@Override
	public Menu navigateMenu() {
		Menu nextMenu = MenuFactory.menuBuilder("account");
		switch (this.getOption()) {
		case "1":
			CurrentUser.setCurrentAccount((accounts.get(0)).getAccountNumber());
			break;

		case "2":
			CurrentUser.setCurrentAccount((accounts.get(1)).getAccountNumber());
			break;
		case "0":
			LogoutService service = new LogoutService();
			nextMenu = MenuFactory.menuBuilder("main");
		}
		return nextMenu;
	}
}
