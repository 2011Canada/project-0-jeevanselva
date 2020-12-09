package com.revature.menus;

import java.util.ArrayDeque;

import com.revature.service.ApplicationService;

public class ApplicationMenuDebugger {
	public static void main(String[] args) {
		ApplicationMenu menu = new ApplicationMenu();
		menu.submitApplication();
		System.out.println("**********************************************");
		ArrayDeque applications = (ArrayDeque) ApplicationService.getApplications();
	}
}
