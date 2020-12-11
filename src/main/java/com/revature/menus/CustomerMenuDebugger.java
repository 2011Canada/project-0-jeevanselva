package com.revature.menus;

import com.revature.models.Account;
import com.revature.models.ChequingAccount;
import com.revature.models.Customer;
import com.revature.service.AccountService;

public class CustomerMenuDebugger {
	public static void main(String[] args) {

		Customer newCustomer = new Customer("Jeevan", "Selva", 50, "123456789", "abc@defg.com", new ChequingAccount());

		Account customerAccount = newCustomer.getAccount();
		AccountService service = new AccountService(customerAccount);

		service.accountBalanceService();
		service.accountDepositService(180);
		service.accountBalanceService();
		service.accountWithdrawalService(24);

		service.accountBalanceService();

		service.accountWithdrawalService(12);
		service.accountBalanceService();
		service.accountDepositService(180);
		service.accountBalanceService();
		service.accountDepositService(180);
	}
}
