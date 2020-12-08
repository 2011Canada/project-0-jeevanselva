package com.revature.repositories;

public class LoginDAOInMemory extends LoginDAO {
	public boolean loginVerify(String userName, String passWord) {
		if (userName.equals("Jeevan") && passWord.equals("Selva")) {
			return true;
		}
		else {
			return false;
		}
		
}
}
