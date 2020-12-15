package com.revature.menus;

import java.util.Scanner;

import com.revature.factory.MenuFactory;
import com.revature.service.AccountService;
import com.revature.service.LogoutService;
import com.revature.service.TransferService;

public class AccountMenu extends Menu {
	AccountService accountService;
	TransferService transferService;
	Scanner scanner;

	public AccountMenu() {
		this.accountService = new AccountService();
		this.transferService = new TransferService();
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void displayMenu() {
		boolean transfer = transferService.checkMoneyTransfer();
		System.out.println("1. Check your balance");
		System.out.println("2. Make a withdrawal");
		System.out.println("3. Make a deposit");
		System.out.println("4. Send money");
		if (transfer) {
			System.out.println("5. Recieved money");
			System.out.println("0. Logout");
		} else {
			System.out.println("0. Logout");
		}
	}

	public void checkBalance() {
		double currentBalance = this.accountService.accountBalanceService();
		System.out.println("Current Balance: " + currentBalance);
	}

	public void withdrawal() {
		boolean valid = false;
		while (!valid) {
			System.out.println("Enter Withdrawal amount: ");
			double amount = scanner.nextDouble();
			valid = accountService.accountWithdrawalService(amount);
			if (valid) {
				System.out.println(amount + " is dispensed");
			} else {
				System.out.println("Invalid transaction");
			}
		}
	}

	public void deposit() {
		boolean valid = false;
		while (!valid) {
			System.out.println("Enter deposit amount: ");
			double amount = scanner.nextDouble();
			valid = accountService.accountDepositService(amount);
			if (valid) {
				System.out.println(amount + " is deposited");
			} else {
				System.out.println("Invalid transaction");
			}
		}
	}

	public void moneyTransfer() {
		boolean valid = false;
		System.out.println("Enter Account Number: ");
		String accountNumber = scanner.nextLine();
		while (!valid) {
			System.out.println("Enter amount: ");
			String amount = scanner.nextLine();
			valid = this.transferService.sendMoneyTransfer(amount, accountNumber);
			if (valid) {
				System.out.println(amount + " is sent to account " + accountNumber);
			} else {
				System.out.println("Invalid transaction");
			}
		}
	}

	public void acceptTransfer() {
		String response;
		System.out.println("1. Accept money transfer");
		System.out.println("2. Decline money transfer");
		response = scanner.nextLine();
		if (response.equals("1")) {
			this.transferService.acceptMoneyTransfer(true);
		} else if (response.equals("2")) {
			this.transferService.acceptMoneyTransfer(false);
		}

	}

	@Override
	public Menu navigateMenu() {
		Menu nextMenu = MenuFactory.menuBuilder("account");
		switch (this.getOption()) {
		case "1":
			this.checkBalance();
			break;
		case "2":
			this.withdrawal();
			break;
		case "3":
			this.deposit();
			break;
		case "4":
			this.moneyTransfer();
			break;
		case "5":
			this.acceptTransfer();
			break;
		case "0":
			LogoutService service = new LogoutService();
			nextMenu = MenuFactory.menuBuilder("main");
		}
		return nextMenu;
	}
}
