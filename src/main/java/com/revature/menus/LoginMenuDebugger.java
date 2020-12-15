package com.revature.menus;

import com.revature.models.CurrentUser;
import com.revature.service.LoginService;

public class LoginMenuDebugger {
	public static void main(String[] args) {
		LoginService service = new LoginService();
		boolean valid = service.loginVerify("j123", "s123");
		System.out.println(valid);
		System.out.println(CurrentUser.getUserId());
		System.out.println(CurrentUser.getRole());

	}
}
