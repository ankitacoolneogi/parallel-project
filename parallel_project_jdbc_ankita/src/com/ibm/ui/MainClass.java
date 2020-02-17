package com.ibm.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import com.ibm.bean.Account;
import com.ibm.bean.Customer;
import com.ibm.bean.Transaction;
import com.ibm.exceptions.BankException;
import com.ibm.service.ServiceClass;

public class MainClass {

	public static void main(String[] args) {
		Customer cus = new Customer();
		ServiceClass b_ser = new ServiceClass();
		Scanner sc = new Scanner(System.in);
		Boolean bool = true;
		boolean mainloop = true, ch = true, val = false;
		while (true) {
			while (mainloop) {

				System.out.println("\t\t~~~~~WELCOME TO SAS WALLET~~~");

				System.out.print("Are you an existing user? (y/n):: ");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					while (bool) {
						try {
							System.out.print("\n\n\t\tEnter user-id:: ");
							cus.setId(sc.nextInt());
						} catch (InputMismatchException im) {
							System.out.println("Wrong input type..should be a number..try again..");
							sc.next();
							continue;
						}

						System.out.print("\t\tEnter password:: ");
						cus.setPassword(sc.next());
						if (b_ser.login(cus)) {
							bool = false;
							ch = true;
							mainloop = false;
						} else if (c == 'n' || c == 'N') {
							System.out.println("~ABORTING !!!!~~");
							System.out.print("Want to try Again?? \n Press 1 to try agaian :: ");
							if (sc.nextInt() != 1)
								return;

						} else {
							System.out.println("Invalid credentials...Please check data and try Again..");
							break;
						}
					}
				}

				else if ((c == 'n' || c == 'N')) {
					System.out.print("Want to create new account?? (y/n) :: ");
					char create_acc = sc.next().charAt(0);
					if (create_acc == 'y' || create_acc == 'Y') {
						sc.nextLine();
						System.out.print("Enter name:: ");
						cus.setName(sc.nextLine());
						val = false;
						while (!val) {
							System.out.print("Enter date-of-birth(yyyy-mm-dd) :: ");
							try {
								cus.setDob(java.sql.Date.valueOf(sc.next()));
								val = true;
							} catch (IllegalArgumentException ilar) {
								System.out.println("DOB invalid...try again..~~~");
								val = false;
							}
						}
						val = false;
						while (!val) {
							System.out.print("Enter mobile number:: ");
							cus.setPhone(sc.next());
							val = b_ser.validatePhone(cus);
							if (!val)
								System.out.println("Wrong input provided... please try again..");
						}
						val = false;
						while (!val) {
							System.out.print("Enter e-mail:: ");
							sc.nextLine();
							cus.setEmail(sc.next());
							val = b_ser.validateMail(cus);
							if (!val)
								System.out.println("Wrong input provided... please try again..");

						}
						val = false;
						while (!val) {
							System.out.print("Create Password:: ");
							cus.setPassword(sc.next());
							try {
								val = b_ser.validatePassword(cus);
							} catch (PatternSyntaxException e) {
								System.out.println("Password should be of length 3 to 8.." + e.getMessage());
							}
							if (!val)
								System.out.println("Wrong input provided... please try again..");

						}
						val = false;
						while (!val) {
							System.out.print("Initial balance:: ");
							cus.a.setBalance(sc.nextInt());
							val = b_ser.validateBalance(cus);
							if (!val)
								System.out.println("Wrong input provided... please try again..");

						}

						b_ser.createAccount(cus);
						mainloop = false;
					} else {
						System.out.println("\t\t~~~~~~~ABORTING !!!!~~~~~~\"");
					}
				} else {
					System.out.println("Invalid credentials...");
				}
			}
			while (ch) {
				System.out.println();
				System.out.println("OPTIONS ARE:  \n");
				System.out.print(
						"1.Withdraw\n2.View\n3.Deposit\n4.Transfer\n5.Check Balance status\n6.Print transactions\n7.Logout\t\tEnter your choice:: ");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter Amount to withdraw: ");
					b_ser.withdrawal(cus, sc.nextInt());
					break;
				case 2:
					ArrayList<Customer> details = b_ser.viewBalance(cus);
					for (Customer k : details) {
						System.out.println(k);
					}

					break;
				case 3:
					System.out.print("Enter Amount to deposit: ");
					b_ser.deposit(cus, sc.nextInt());
					break;
				case 4:
					
					
					boolean temp=false;
					int ac=0;
				do{
					System.out.print("Enter receiving account no : ");
					 ac =sc.nextInt();
					temp=b_ser.isAccountExist(ac);
					if(temp==false)
						System.out.println("Account number doesn't exist, please enter another..");
				}while(temp==false);
				
				System.out.print("Enter Amount to send : ");
				b_ser.send(cus, ac, sc.nextInt());
				break;
				case 5:
					if (b_ser.lowBalance(cus))
						System.out.print("Account is in low-balance state...");
					else
						System.out.println("Account status is healthy..");
					break;
				case 6:
					ArrayList<Transaction> det = b_ser.printTransaction(cus);
					for (Transaction m : det) {
						System.out.println(m);
					}
					break;
				case 7: {
					System.out.println("sucessfully logged out");
					ch = false;
					bool = true;
					break;
				}
				default:
					System.out.println("Wrong Input....");
				}

				mainloop = true;

			}
		}
	}
}
