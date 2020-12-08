package com.revature.menus;

import com.revature.service.LoginService;
public class LoginMenu {
LoginService service;
	public LoginMenu(LoginService service) {
		this.service = service;
	}
	
	
	public void getValidated (String userName, String password) {
		boolean verified = false;
		while(verified) {
			service.loginVerify(userName,password);
		};
	}

}
