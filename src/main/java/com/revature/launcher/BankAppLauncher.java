package com.revature.launcher;

import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.menus.Menu;

public class BankAppLauncher {
	public static void main(String[] args) {
		try {
			Menu currentMenu = MenuFactory.menuBuilder("main");
			int option = 0;
			Scanner scanner = new Scanner(System.in);
			currentMenu.displayMenu();
			while (true) {
				scanner.next();
				option = scanner.nextInt();
				currentMenu.setOption(option);
				Menu nextMenu = currentMenu.navigateMenu();
				currentMenu = nextMenu;
				currentMenu.displayMenu();

			}

		} catch (NullPointerException e) {
		}
	}
}
