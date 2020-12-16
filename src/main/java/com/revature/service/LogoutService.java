package com.revature.service;

public class LogoutService {

	public LogoutService() {
	}

	public static void logout() {
		UserService.clearCurrentUser();
	}
}
