package com.revature.service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class LoginService {

	public LoginService() {
	}

	public boolean loginVerify(String userName, String password) {
		UserDAO dao = new UserDAO();
		User currentUser = dao.readUser(userName, password);
		if (currentUser != null) {
			System.out.println(currentUser);
			return true;
		} else
			return false;

	}
}
