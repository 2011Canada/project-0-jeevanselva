package com.revature.menus;

import com.revature.service.LoginService;

public class LoginMenuDebugger {
	public static void main(String[] args) {
		LoginService loginCheck = new LoginService();
		LoginMenu loginMenu = new LoginMenu(loginCheck);
		loginMenu.getUserCredentials();
	}
}
