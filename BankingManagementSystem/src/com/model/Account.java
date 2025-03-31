package com.model;
public abstract class Account {
	private String accountNumber;
	private Customer customer;
	private double balance;
	public Account(String accountNumber, Customer customer, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		balance = balance + amount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public abstract void withdraw(double amount);
}
