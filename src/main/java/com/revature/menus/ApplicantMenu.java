package com.revature.menus;

import java.util.Scanner;

import com.revature.service.ApplicantService;
public class ApplicantMenu {
private ApplicantService service;
	
public ApplicantMenu(ApplicantService service) {
		this.service = service;
	}

public void newApplication() {
	System.out.println("Please enter your First Name: ");
	System.out.println("Please enter your Last Name: ");
	System.out.println("Please enter your Age: ");
	System.out.println("Please enter your Phone Number: ");
	System.out.println("Please enter your E-mail Address: ");
	
}

	}
