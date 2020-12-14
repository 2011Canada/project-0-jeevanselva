package com.revature.models;

public class CurrentUser {
	private static int userId;
	private static String role;

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		CurrentUser.userId = userId;
	}

	public static String getRole() {
		return role;
	}

	public static void setRole(String role) {
		CurrentUser.role = role;
	}
}
