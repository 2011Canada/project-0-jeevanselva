package com.revature.menus;

import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.models.Account;
import com.revature.models.Application;
import com.revature.models.ChequingAccount;
import com.revature.models.Customer;
import com.revature.models.SavingsAccount;
import com.revature.service.ApplicationService;

public class ApplicationMenu extends Menu {

	public ApplicationMenu() {
	}

	@Override
	public void displayMenu() {
		this.newApplication();
		System.out.println();
		System.out.println("Your application has been submitted");
		System.out.println();
		System.out.println("Press 0 to exit");

	}

	public void newApplication() {
		Scanner scanner = new Scanner(System.in);
		String firstName;
		String lastName;
		int age;
		String emailAddress;
		String phoneNumber;
		int accountOption;
		Account accountType = null;

		System.out.println("Please enter your First Name: ");
		firstName = scanner.nextLine();

		System.out.println("Please enter your Last Name: ");
		lastName = scanner.nextLine();
		System.out.println("Please enter your Age: ");
		age = scanner.nextInt();

		System.out.println("Please enter your Phone Number: ");
		scanner.next();
		phoneNumber = scanner.nextLine();

		System.out.println("Please enter your E-mail Address: ");
		emailAddress = scanner.nextLine();

		System.out.println("Please select what type of bank account you are applying for: ");
		System.out.println("Press 1 for Chequing account");
		System.out.println("Press 2 for Savings account");

		accountOption = scanner.nextInt();

		if (accountOption == 1) {
			accountType = new ChequingAccount();

		} else if (accountOption == 2) {
			accountType = new SavingsAccount();
		}
		Customer newCustomer = new Customer(firstName, lastName, age, phoneNumber, emailAddress, accountType);
		Application newApplication = new Application(newCustomer);
		ApplicationService.addApplication(newApplication);
	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = null;
		switch (this.getOption()) {
		case 1:
			nextMenu = MenuFactory.menuBuilder("main");
			break;
		}
		return nextMenu;

	}

}
