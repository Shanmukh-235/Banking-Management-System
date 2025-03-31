package com.view;
import java.util.Scanner;
import com.controller.BankingService;
public class BankingManagementSystem {
	public static void main(String[] args) {
		BankingService service = new BankingService();
		Scanner sc = new Scanner(System.in);
		System.out.println("*********** Welcome to Banking Management System ***********");
		while(true) {
			System.out.println("1. Create Customer");
			System.out.println("2. Create Account");
			System.out.println("3. Withdraw amount");
			System.out.println("4. Deposit amount");
			System.out.println("5. View balance");
			System.out.println("6. View Accounts");
			System.out.println("7. Exit");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
						{
							System.out.println("Enter Customer ID:");
							String cid=sc.next();
							System.out.println("Enter Customer name");
							String cname=sc.next();
							service.createCustomer(cid,cname);
							break;
						}
				case 2:
						{
							System.out.println("Enter Account Type: Savings/Current");
							String acc_type=sc.next();
							System.out.println("Enter Account Number: ");
							String acc_num=sc.next();
							System.out.println("Enter Customer ID: ");
							String cus_id=sc.next();
							System.out.println("Enter Initial balance: ");
							double balance=sc.nextDouble();
							service.createAccount(acc_type,acc_num,cus_id,balance);
							break;
						}
				case 3:
						{
							System.out.println("Enter account number: ");
							String withdraw_acc_num=sc.next();
							System.out.println("Enter withdrawal amount: ");
							double withdraw_amount=sc.nextDouble();
							service.withdrawAmount(withdraw_acc_num,withdraw_amount);
							break;
						}
				case 4:
						{
							System.out.println("Enter account number: ");
							String deposit_acc_num=sc.next();
							System.out.println("Enter deposit amount: ");
							double deposit_amount=sc.nextDouble();
							service.depositAmount(deposit_acc_num,deposit_amount);
							break;
						}
				case 5:
						{
							System.out.println("Enter account number: ");
							String check_acc_num=sc.next();
							service.checkBalance(check_acc_num);
							break;
						}
				case 6:
						{
							service.getAccounts();
							break;
						}
				case 7:
						System.out.println("Thank YOu, Visit Again");
						System.exit(0);
				default: System.out.println("Enter valid option");
				break;
			}
		}
	}
}
