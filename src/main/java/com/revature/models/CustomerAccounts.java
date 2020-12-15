package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class CustomerAccounts {
	List<Account> accounts = new ArrayList<Account>();

	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAccounts other = (CustomerAccounts) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "while CustomerAccounts [accounts=" + accounts + "]";
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

}
