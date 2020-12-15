package com.revature.menus;

import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.service.LoginService;

public class LoginMenu extends Menu {
	private LoginService service;
	Scanner scanner = new Scanner(System.in);

	public LoginMenu() {
		service = new LoginService();
	}

	@Override

	public void displayMenu() {
		this.getInput();
		System.out.println();
		System.out.println("You have successfuly logged in!");
		System.out.println("Press 1 to continue");
	}

	public void getInput() {
		boolean verified = false;
		do {
			System.out.println("Please enter your username: ");
			String userName = scanner.nextLine();
			System.out.println("Please enter your password: ");
			String password = scanner.nextLine();
			verified = this.getValidated(userName, password);
			if (!verified) {
				System.out.println("Your user name and password don't match our records!");
				System.out.println("Please try again!");
			}
		} while (!verified);
	}

	public boolean getValidated(String userName, String password) {

		return service.loginVerify(userName, password);
	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = null;
		switch (this.getOption()) {
		case "1":
			nextMenu = MenuFactory.menuBuilder("customer");
			/*
			 * if (CurrentUser.getRole().equals("customer")) {
			 * 
			 * } else if (CurrentUser.getRole().equals("employee")) { nextMenu =
			 * MenuFactory.menuBuilder("employee"); }
			 */
			break;

		}
		return nextMenu;

	}

}
