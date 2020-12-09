package com.revature.menus;

import java.util.Scanner;

import com.revature.service.ApplicantService;
import com.revature.models.Application;
public class ApplicantMenu {
private ApplicantService service;
	
public ApplicantMenu(ApplicantService service) {
		this.service = service;
	}

public void submitApplication() {
	Scanner scanner = new Scanner(System.in);
	String firstName;
	String lastName;
	int age;
	String emailAddress;
	int phoneNumber;
	int accountType;
	System.out.println("Please enter your First Name: ");
	firstName = scanner.nextLine();
	System.out.println("Please enter your Last Name: ");
	lastName = scanner.nextLine();
	System.out.println("Please enter your Age: ");
	age = scanner.nextInt();
	System.out.println("Please enter your Phone Number: ");
	phoneNumber = scanner.nextInt();
	System.out.println("Please enter your E-mail Address: ");
	emailAddress = scanner.nextLine();
	System.out.println("Please select what type of bank account you are applying for: ");
	System.out.println("Press 1 for Chequing account");
	System.out.println("Press 2 for Chequing account");
	accountType = scanner.nextInt();
	
	
}

	}
