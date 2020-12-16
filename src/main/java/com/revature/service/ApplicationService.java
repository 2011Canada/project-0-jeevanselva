package com.revature.service;

import java.util.ArrayDeque;
import java.util.Queue;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Account;
import com.revature.models.Application;
import com.revature.models.Customer;
import com.revature.models.Person;
import com.revature.models.User;

public class ApplicationService {

	private static ArrayDeque<Application> applicationQueue = new ArrayDeque<Application>();

	public static void addApplicationToQueue(Application newApplication) {
		applicationQueue.add(newApplication);
	}

	public static Queue<Application> getApplications() {
		return applicationQueue;
	}

	public boolean checkNewApplications() {
		if (applicationQueue.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public Application getApplicationFromQueue() {
		return applicationQueue.removeFirst();
	}

	public void submitApplication(Person person, Account account, User user) {
		Customer newCustomer = new Customer(person, account, user);
		Application newApplication = new Application(newCustomer);
		ApplicationService.addApplicationToQueue(newApplication);
		BankAppLauncher.appLogger.info("New customer application submitted");
	}

}