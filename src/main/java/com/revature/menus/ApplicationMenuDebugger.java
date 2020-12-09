package com.revature.menus;

import java.util.ArrayDeque;

import com.revature.models.Application;
import com.revature.service.ApplicationService;

public class ApplicationMenuDebugger {
	public static void main(String[] args) {
		ApplicationMenu menu = new ApplicationMenu();
		menu.submitApplication();
		System.out.println("**********************************************");
		ArrayDeque<Application> applications = (ArrayDeque<Application>) ApplicationService.getApplications();
		System.out.println(applications.getFirst());
	}
}
