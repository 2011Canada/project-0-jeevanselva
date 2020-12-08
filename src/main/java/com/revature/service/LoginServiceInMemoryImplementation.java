package com.revature.service;

public class LoginServiceInMemoryImplementation implements LoginService{

	public boolean loginVerify(String userName, String passWord) {
	if (userName.equals("Jeevan") && passWord.equals("Selva")) {
		return true;
	}
	else {
		return false;
	}
	
}
}

