package com.revature.models;

public class ChequingAccount extends Account {

	public ChequingAccount() {
		super();

	}
	
	public void accountWithdrawal(double withdrawalAmount) {
		if (this.getAccountBalance()-withdrawalAmount < 0) {
			System.out.println("This is an invalid Transaction");
		}
		else {
			double balance = this.getAccountBalance() - withdrawalAmount;
			this.setAccountBalance(balance);
		}
	}
	

}
