package com.revature.menus;

import com.revature.factory.MenuFactory;

public class MainMenu extends Menu {

	@Override
	public void displayMenu() {

		System.out.println("1. Login: If you already have an account");
		System.out.println("2. Register: If you want to create a new Bank account");
	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = null;
		switch (this.getOption()) {
		case 1:
			nextMenu = MenuFactory.menuBuilder("login");
			break;

		case 2:
			nextMenu = MenuFactory.menuBuilder("application");
			break;
		}
		return nextMenu;

	}

}
