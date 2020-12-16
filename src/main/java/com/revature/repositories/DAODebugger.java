package com.revature.repositories;

import com.revature.models.Account;

public class DAODebugger {
	public static void main(String[] args) {
		Account account = new Account();
		account.setUserId(1);
		account.setAccountBalance(1000);
		account.setAccountNumber(300);
		account.setType("Savings");

		AccountDAO dao = new AccountDAO();
		dao.createAccount(account);
	}

}
