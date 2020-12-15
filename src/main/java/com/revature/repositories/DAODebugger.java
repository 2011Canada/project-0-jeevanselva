package com.revature.repositories;

import com.revature.models.Account;
import com.revature.models.ChequingAccount;

public class DAODebugger {
	public static void main(String[] args) {

		AccountDAO dao = new AccountDAO();
		Account account = new ChequingAccount();
		account.setUserId(10);
		account = dao.createAccount(account);
		System.out.println(account);
	}

}
