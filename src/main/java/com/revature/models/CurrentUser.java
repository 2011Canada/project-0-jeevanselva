package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser {
	private static int userId;
	private static String role;
	private static String name;
	private static int currentAccount;
	private static List<Account> accounts = new ArrayList<Account>();

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		CurrentUser.userId = userId;
	}

	public static String getRole() {
		return role;
	}

	public static void setRole(String role) {
		CurrentUser.role = role;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		CurrentUser.name = name;
	}

	public static int getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(int currentAccount) {
		CurrentUser.currentAccount = currentAccount;
	}

	public static List<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(List<Account> accounts) {
		CurrentUser.accounts = accounts;
	}

}
