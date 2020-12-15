package com.revature.menus;

public abstract class Menu {

	private String option;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public abstract void displayMenu();

	public abstract Menu navigateMenu();
}
