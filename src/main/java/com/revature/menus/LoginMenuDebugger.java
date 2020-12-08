package com.revature.menus;

import com.revature.repositories.LoginDAO;
import com.revature.repositories.LoginDAOInMemory;
import com.revature.service.LoginService;

public class LoginMenuDebugger {
public static void main(String[] args) {
	LoginDAO inMemory = new LoginDAOInMemory();
	LoginService loginCheck = new LoginService(inMemory);
	LoginMenu loginMenu = new LoginMenu(loginCheck);
	loginMenu.getUserCredentials();
}
}
