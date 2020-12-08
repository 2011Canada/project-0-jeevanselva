package com.revature.service;
import  com.revature.repositories.LoginDAO;


public class LoginService {

	LoginDAO userCredentials;
	
	public LoginService (LoginDAO userCredentials) {
		this.userCredentials = userCredentials;
	}
	
	public boolean loginVerify(String userName, String password) {
	return userCredentials.loginVerify(userName, password);
}
}

