package com.revature.menus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.ChequingAccount;
import com.revature.models.CurrentUser;

public class AccountMenuDebugger {
	public static Logger appLogger = LogManager.getLogger("com.revature.banklogger");

	public static void main(String[] args) {
		CurrentUser.setUserId(10);
		Account ac = new ChequingAccount();
		System.out.println(ac);
		BankAppLauncher.appLogger.debug("");

	}
}
