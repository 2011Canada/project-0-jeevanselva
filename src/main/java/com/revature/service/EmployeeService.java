package com.revature.service;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.Application;
import com.revature.models.CurrentUser;
import com.revature.models.Customer;
import com.revature.models.ListOfAccounts;
import com.revature.models.Person;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.PersonDAO;
import com.revature.repositories.UserDAO;

public class EmployeeService {

	public ListOfAccounts viewAllCustomerAccounts() {
		AccountDAO dao = new AccountDAO();
		return dao.getAllAccounts();
	}

	public void approveApplication(Application newApplication) {
		Customer newCustomer = newApplication.getNewCustomer();
		PersonDAO personDao = new PersonDAO();
		UserDAO userDao = new UserDAO();
		AccountDAO accountDao = new AccountDAO();
		Person newPerson = newCustomer.getPerson();
		Account newAccount = newCustomer.getAccount();
		User newUser = newCustomer.getUser();
		newPerson = personDao.createPerson(newPerson);
		int personId = newPerson.getPersonId();
		newUser.setPersonId(personId);
		newUser = userDao.createUser(newUser);
		int userId = newUser.getUserId();
		newAccount.setUserId(userId);
		accountDao.createAccount(newAccount);
		BankAppLauncher.appLogger.debug("Employee Id: " + CurrentUser.getUserId() + " approved new application");
	}

}
