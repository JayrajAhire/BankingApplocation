package com.app.model;

public class Customer {
	
	private long accountNumber;
	private long accountBalance;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(long accountNumber, long accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}


}
