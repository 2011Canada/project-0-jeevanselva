package com.revature.menus;

import com.revature.models.CustomerAccounts;
import com.revature.service.EmployeeService;

public class EmployeeMenuDebugger {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		CustomerAccounts accounts = service.viewAllCustomerAccounts();
		System.out.println(accounts);
	}

}
