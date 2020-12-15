package com.revature.menus;

import com.revature.models.Application;
import com.revature.service.ApplicationService;
import com.revature.service.EmployeeService;

public class ApplicationMenuDebugger {
	public static void main(String[] args) {

		ApplicationService as = new ApplicationService();
		ApplicationMenu am = new ApplicationMenu();

		EmployeeService es = new EmployeeService();

		boolean newApplication = as.checkNewApplications();
		System.out.println("Any new applications: " + newApplication);
		am.displayMenu();
		newApplication = as.checkNewApplications();
		System.out.println("Any new applications: " + newApplication);
		Application newApp;
		if (newApplication) {
			newApp = as.getApplicationFromQueue();
			es.approveApplication(newApp);
		} else {
			System.out.println("This did not work!");
		}

	}
}
