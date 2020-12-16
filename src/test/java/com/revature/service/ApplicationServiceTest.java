package com.revature.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.models.Account;
import com.revature.models.Application;
import com.revature.models.Person;
import com.revature.models.User;

public class ApplicationServiceTest {
	ApplicationService service = new ApplicationService();
	Application newApplication;

	/*
	 * all methods in ApplicationService is tested through this test when a customer
	 * submits an application, the customer object has three objects (person,
	 * account, user) which forms the application object which is put on a queue for
	 * the employer to accept or decline, the application retrieved from the queue
	 * is being tested to see if it is the same person object.
	 */

	@Test
	public void checkApplicationOnQueue() {
		Person person = new Person();
		Account account = new Account();
		User user = new User();
		service.submitApplication(person, account, user);
		Assertions.assertEquals(person, ((service.getApplicationFromQueue()).getNewCustomer()).getPerson());
	}

}
