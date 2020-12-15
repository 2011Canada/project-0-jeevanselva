package com.revature.launcher;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.factory.MenuFactory;
import com.revature.menus.Menu;

public class BankAppLauncher {
	public static Logger appLogger = LogManager.getLogger("com.revature.banklogger");

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Menu currentMenu = MenuFactory.menuBuilder("main");
		String option;

		currentMenu.displayMenu();
		while (true) {
			option = scanner.nextLine();
			currentMenu.setOption(option);
			Menu nextMenu = currentMenu.navigateMenu();
			currentMenu = nextMenu;
			currentMenu.displayMenu();

		}
	}
}
