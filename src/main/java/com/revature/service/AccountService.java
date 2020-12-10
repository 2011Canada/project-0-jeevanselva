package com.revature.service;

import com.revature.repositories.AccountDAO;

public class AccountService {

	AccountDAO accountDetails;
	
	public AccountService(AccountDAO accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	
}
