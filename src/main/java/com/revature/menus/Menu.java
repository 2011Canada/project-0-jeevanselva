package com.revature.menus;

public abstract class Menu {

	private int option;

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public abstract void displayMenu();

	public abstract Menu navigateMenu();
}
