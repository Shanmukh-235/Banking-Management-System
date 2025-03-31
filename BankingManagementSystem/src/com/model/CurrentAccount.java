package com.model;
public class CurrentAccount extends Account{
	private static final double OVER_DRAFT_LIMIT = - 5000;
	public CurrentAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}
	@Override
	public void withdraw(double amount) {	
		if(getBalance() - amount >= OVER_DRAFT_LIMIT) {
			System.out.println("Withdraw Success");
		} else {
			System.err.println("You exceeded overdraft limit");
		}
	}
}
