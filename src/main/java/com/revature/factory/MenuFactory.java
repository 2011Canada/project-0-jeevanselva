package com.revature.factory;

import com.revature.menus.ApplicationMenu;
import com.revature.menus.EmployeeMenu;
import com.revature.menus.LoginMenu;
import com.revature.menus.MainMenu;
import com.revature.menus.Menu;

public class MenuFactory {
	public static Menu menuBuilder(String type) {
		if (type.equalsIgnoreCase("login")) {
			return new LoginMenu();
		} else if (type.equalsIgnoreCase("application")) {
			return new ApplicationMenu();
		} else if (type.equalsIgnoreCase("main")) {
			return new MainMenu();
		} else if (type.equalsIgnoreCase("customer")) {
			return new MainMenu();

		} else if (type.equalsIgnoreCase("employee")) {
			return new EmployeeMenu();
		} else {
			return null;
		}
	}
}
