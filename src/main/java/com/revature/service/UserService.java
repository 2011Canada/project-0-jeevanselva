package com.revature.service;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.CurrentUser;
import com.revature.models.User;

public class UserService {
	public static void setCurrentUser(User user) {
		CurrentUser.setUserId(user.getUserId());
		CurrentUser.setRole(user.getRole());
		BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " Logged in");
	}

	public static void clearCurrentUser() {
		BankAppLauncher.appLogger.debug(CurrentUser.getUserId() + " Logged out");
		CurrentUser.setUserId(-1);
		CurrentUser.setRole(null);
	}

}
