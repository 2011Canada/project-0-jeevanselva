package com.revature.menus;

import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.models.Account;
import com.revature.models.ChequingAccount;
import com.revature.models.Person;
import com.revature.models.SavingsAccount;
import com.revature.models.User;
import com.revature.service.ApplicationService;

public class ApplicationMenu extends Menu {
	Scanner scanner = new Scanner(System.in);

	public ApplicationMenu() {

	}

	@Override
	public void displayMenu() {
		Person person = this.newPerson();
		Account account = this.newAccount();
		User user = this.newUser();
		ApplicationService applicationService = new ApplicationService();
		applicationService.submitApplication(person, account, user);
		System.out.println("Your application has been submitted");
		System.out.println();
		System.out.println("Press 0 to exit");
	}

	public Person newPerson() {
		String firstName;
		String lastName;
		String age;
		String emailAddress;
		String phoneNumber;

		System.out.println("Please enter your First Name: ");
		firstName = scanner.nextLine();

		System.out.println("Please enter your Last Name: ");
		lastName = scanner.nextLine();
		System.out.println("Please enter your Age: ");
		age = scanner.nextLine();
		System.out.println("Please enter your Phone Number: ");
		phoneNumber = scanner.nextLine();
		System.out.println("Please enter your E-mail Address: ");
		emailAddress = scanner.nextLine();

		int ageInteger = Integer.parseInt(age);
		Person newPerson = new Person(firstName, lastName, ageInteger, phoneNumber, emailAddress);

		return newPerson;
	}

	public Account newAccount() {
		String option;
		Account accountType = null;
		System.out.println("Please select what type of bank account you are applying for: ");
		System.out.println("Press 1 for Chequing account");
		System.out.println("Press 2 for Savings account");

		option = scanner.nextLine();

		if (option.equals("1")) {
			accountType = new ChequingAccount();

		} else if (option.equals("2")) {
			accountType = new SavingsAccount();
		}

		return accountType;
	}

	public User newUser() {
		String userName;
		String password;

		System.out.println("Please enter a user name: ");
		userName = scanner.nextLine();

		System.out.println("Please enter a password: ");
		password = scanner.nextLine();

		User newUser = new User(userName, password);

		return newUser;
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
