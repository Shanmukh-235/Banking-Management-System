package com.model;
public class SavingsAccount extends Account {
	private static final double MINIMUM_BALANCE = 500.00;
	public SavingsAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}

	@Override
	public void withdraw(double amount) {
		if(getBalance() - amount >= MINIMUM_BALANCE) {
			System.out.println("Withdraw Success");
			setBalance(getBalance() - amount);
		} else {
			System.err.println("Insufficient balance");
		}
	}
}
