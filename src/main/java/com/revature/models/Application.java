package com.revature.models;

public class Application {
	private Customer newCustomer;
	private String statusOfApplication;

	public Application(Customer newCustomer) {
		super();
		this.newCustomer = newCustomer;
		this.statusOfApplication = "pending";
	}

	public Customer getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

	public String getStatusOfApplication() {
		return statusOfApplication;
	}

	public void setStatusOfApplication(String statusOfApplication) {
		this.statusOfApplication = statusOfApplication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newCustomer == null) ? 0 : newCustomer.hashCode());
		result = prime * result + ((statusOfApplication == null) ? 0 : statusOfApplication.hashCode());
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
		Application other = (Application) obj;
		if (newCustomer == null) {
			if (other.newCustomer != null)
				return false;
		} else if (!newCustomer.equals(other.newCustomer))
			return false;
		if (statusOfApplication == null) {
			if (other.statusOfApplication != null)
				return false;
		} else if (!statusOfApplication.equals(other.statusOfApplication))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [newCustomer=" + newCustomer + ", statusOfApplication=" + statusOfApplication + "]";
	}

}
