package com.revature.service;

import com.revature.models.CurrentUser;
import com.revature.models.User;

public class UserService {
	public static void setCurrentUser(User user) {
		CurrentUser.setUserId(user.getUserId());
		CurrentUser.setRole(user.getRole());
	}

	public static void clearCurrentUser() {
		CurrentUser.setUserId(0);
		CurrentUser.setRole(null);
	}

}
