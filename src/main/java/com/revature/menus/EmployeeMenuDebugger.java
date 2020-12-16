package com.revature.menus;

import com.revature.models.Account;
import com.revature.models.Person;
import com.revature.models.User;
import com.revature.service.ApplicationService;

public class EmployeeMenuDebugger {

	public static void main(String[] args) {
		Person person = new Person();
		Account account = new Account();
		User user = new User();

		EmployeeMenu em = new EmployeeMenu();
		ApplicationService as = new ApplicationService();

		em.viewAllTransactions();

	}

}
