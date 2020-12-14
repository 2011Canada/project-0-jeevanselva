package com.revature.menus;

import com.revature.factory.MenuFactory;

public class AccountMenu extends Menu {

	@Override
	public void displayMenu() {
		System.out.println("1. Check your balance");
		System.out.println("2. Make a withdrawal");
		System.out.println("3. Make a deposit");
		System.out.println("4. Transfer money");
	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = null;
		switch (this.getOption()) {
		case 1:
			nextMenu = MenuFactory.menuBuilder("customer");
			break;
		}
		return nextMenu;
	}

}
