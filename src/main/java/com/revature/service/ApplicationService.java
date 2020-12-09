package com.revature.service;

import java.util.ArrayDeque;
import java.util.Queue;

import com.revature.models.Application;

public class ApplicationService {

	private static Queue<Application> applicationQueue = new ArrayDeque<Application>();

	public static void addApplication(Application newApplication) {
		applicationQueue.add(newApplication);
	}

	public static Queue<Application> getApplications() {
		return applicationQueue;
	}

}
