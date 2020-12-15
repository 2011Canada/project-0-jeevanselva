package com.revature.service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class LoginService {

	public LoginService() {
	}

	public boolean loginVerify(String userName, String password) {
		UserDAO dao = new UserDAO();
		User currentUser = dao.readUser(userName, password);
		UserService.setCurrentUser(currentUser);
		if (currentUser != null) {
			return true;
		} else
			return false;

	}
}
