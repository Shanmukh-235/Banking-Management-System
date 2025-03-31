package com.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.model.Account;
import com.model.CurrentAccount;
import com.model.Customer;
import com.model.SavingsAccount;

public class BankingService {
	LinkedHashMap<String, Account> accounts=new LinkedHashMap<String, Account>();
	LinkedHashMap<String, Customer> customers=new LinkedHashMap<String, Customer>();
	public void createCustomer(String cid, String cname) {
		if(customers.containsKey(cid)==false) {
			Customer customer=new Customer(cid, cname);
			customers.put(cid, customer);
			System.out.println("Customer created successfully\n");
		}
		else {
			System.out.println("Customer already exists\n");
		}	
	}
	public void createAccount(String acc_type, String acc_num, String cus_id, double balance) {
		if(accounts.containsKey(acc_num)==false) {
			if(customers.containsKey(cus_id)==true) {
				if(acc_type.equals("Savings")){
					Customer customer=customers.get(cus_id);
					Account account=new SavingsAccount(acc_num, customer, balance);
					accounts.put(acc_num, account);
					System.out.println("Account creation successful\n");
				}
				else if(acc_type.equals("Current")) {
					Customer customer=customers.get(cus_id);
					Account account=new CurrentAccount(acc_num, customer, balance);
					accounts.put(acc_num, account);
					System.out.println("Account creation successful\n");
				}
				else {
					System.out.println("Invalid acccount type\n");
				}
			}
			else {
				System.out.println("Customer doesn't exist\n");
			}
		}
		else {
			System.out.println("Account already exists\n");
		}
	}
	public void withdrawAmount(String withdraw_acc_num, double withdraw_amount) {
		if(accounts.containsKey(withdraw_acc_num)==true) {
			Account account=accounts.get(withdraw_acc_num);
			account.withdraw(withdraw_amount);
		}
		else {
			System.out.println("Account doesn't exist\n");
		}

	}
	public void depositAmount(String deposit_acc_num, double deposit_amount) {
		if(accounts.containsKey(deposit_acc_num)==true) {
			Account account=accounts.get(deposit_acc_num);
			account.deposit(deposit_amount);
			System.out.println("Amount deposit successful\n");
		}
		else {
			System.out.println("Account doesn't exist\n");
		}	
	}
	public void checkBalance(String check_acc_num) {
		if(accounts.containsKey(check_acc_num)==true) {
			Account account=accounts.get(check_acc_num);
			System.out.println("Your account balance is :"+account.getBalance()+"\n");
		}
		else {
			System.out.println("Account doesn't exist\n");
		}
	}
	public void getAccounts() {
		Collection<Account> viewaccounts=accounts.values();
		for(Account obj:viewaccounts) {
			System.out.println(obj);
		}

	}
	public void deleteAccount(String del_acc_num) {
		if(accounts.containsKey(del_acc_num)==true) {
			Account account=accounts.get(del_acc_num);
			Customer customer=account.getCustomer();
			accounts.remove(del_acc_num);
			customers.remove(customer.getId());
			System.out.println("Your account deleted successfully"+"\n");
		}
		else {
			System.out.println("Account doesn't exist\n");
		}

	}	
}