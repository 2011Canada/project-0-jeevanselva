package com.revature.service;

public class LogoutService {

	public LogoutService() {
	}

	public void logout() {
		UserService.clearCurrentUser();
	}
}
