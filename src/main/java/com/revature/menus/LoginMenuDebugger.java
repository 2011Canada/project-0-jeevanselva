package com.revature.menus;

import com.revature.service.LoginService;
import com.revature.service.LoginServiceInMemoryImplementation;

public class LoginMenuDebugger {
public static void main(String[] args) {
	LoginService loginCheck = new LoginServiceInMemoryImplementation();
	LoginMenu loginMenu = new LoginMenu(loginCheck);
	loginMenu.getUserCredentials();
}
}
