package com.revature.menus;

import com.revature.models.CurrentUser;
import com.revature.repositories.AccountDAO;
import com.revature.service.AccountService;

public class AccountMenuDebugger {
	public static void main(String[] args) {
		CurrentUser.setUserId(5);
		AccountDAO dao = new AccountDAO();
		dao.accountUpdate(200);
		AccountService service = new AccountService();
		double balance = service.accountBalanceService();
		System.out.println(balance);
	}
}
