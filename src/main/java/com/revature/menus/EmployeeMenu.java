package com.revature.menus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.Application;
import com.revature.models.ListOfAccounts;
import com.revature.service.ApplicationService;
import com.revature.service.EmployeeService;
import com.revature.service.LogoutService;

public class EmployeeMenu extends Menu {
	EmployeeService employeeService;
	ApplicationService applicationService;
	Scanner employeeScanner;

	public EmployeeMenu() {
		this.employeeService = new EmployeeService();
		this.applicationService = new ApplicationService();
		this.employeeScanner = new Scanner(System.in);
	}

	@Override
	public void displayMenu() {
		System.out.println();
		System.out.println("1. Check New Applications");
		System.out.println("2. View Customer Accounts");
		System.out.println("3. View all transactions");
		System.out.println("0. Logout");
		System.out.println();
	}

	public void viewCustomers() {
		ListOfAccounts accounts = employeeService.viewAllCustomerAccounts();
		ArrayList<Account> viewAccounts = (ArrayList<Account>) accounts.getAccounts();
		Iterator<Account> iteratorAccounts = viewAccounts.iterator();
		while (iteratorAccounts.hasNext()) {
			System.out.println(iteratorAccounts.next());
		}
		System.out.println();

	}

	public void checkApplications() {
		boolean check;
		check = applicationService.checkNewApplications();
		if (check == true) {
			this.retrieveApplication();
		} else {
			System.out.println("No new applications");
		}
	}

	public void viewAllTransactions() {

		try {
			BufferedReader logReader = new BufferedReader(new FileReader(System.getenv("FILE")));
			String logLine;

			while ((logLine = logReader.readLine()) != null) {

				System.out.println(logLine);
			}

		} catch (IOException e) {

			BankAppLauncher.appLogger.error("log file could not be opened");
		}
		System.out.println();
	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = MenuFactory.menuBuilder("employee");
		switch (this.getOption()) {
		case "1":
			this.checkApplications();
			break;

		case "2":
			this.viewCustomers();
			break;
		case "3":
			this.viewAllTransactions();
			break;
		case "0":
			LogoutService.logout();
			nextMenu = MenuFactory.menuBuilder("main");
		}
		return nextMenu;
	}

	public void retrieveApplication() {
		boolean notEmpty;
		notEmpty = applicationService.checkNewApplications();
		Application newApplication;
		while (notEmpty) {
			int count = 1;
			System.out.println(count + ".");
			newApplication = applicationService.getApplicationFromQueue();
			System.out.println(newApplication);
			this.approveApplication(newApplication);
			notEmpty = applicationService.checkNewApplications();
		}
		System.out.println("No more applications");

	}

	public void approveApplication(Application application) {
		System.out.println("1. Accept");
		System.out.println("2. Decline");
		String option = this.employeeScanner.nextLine();
		if (option.equals("1")) {
			employeeService.approveApplication(application);
			System.out.println("Application approved");
		} else if (option.equals("2")) {
			System.out.println("Application declined");
		}
	}
}
