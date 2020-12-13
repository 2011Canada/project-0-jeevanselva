package com.revature.menus;

import java.util.Scanner;

import com.revature.service.LoginService;

public class LoginMenu {
	private LoginService service;

	public LoginMenu(LoginService service) {
		this.service = service;
	}

	public void getUserCredentials() {
		Scanner scanner = new Scanner(System.in);
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
		System.out.println("Welcome!");

	}

	public boolean getValidated(String userName, String password) {

		return service.loginVerify(userName, password);
	};
}
