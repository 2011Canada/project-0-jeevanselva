package com.revature.models;

public class Customer {
	private Person person;
	private Account account;
	private User user;

	public Customer(Person person, Account account, User user) {
		super();
		this.person = person;
		this.account = account;
		this.user = user;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + ", account=" + account + ", user=" + user + "]";
	}

}
