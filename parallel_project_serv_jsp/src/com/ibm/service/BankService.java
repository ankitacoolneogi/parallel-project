
package com.ibm.service;

import java.util.ArrayList;
import com.ibm.bean.Customer;
import com.ibm.bean.Transaction;

public interface BankService {
	public static final String USERPASSWORDPATTERN="[a-zA-Z0-9]{8}";
	public static final String USERMAILPATTERN="[a-zA-Z0-9.]+@[a-z]+.com";
	public static final String USERPHONEPATTERN="[6-9]{1}[0-9]{9}";
	public static final String USERDOBPATTERN="[0-9]{4}+-[0-9]{2}+-[0-9]{2}";
	
	
	public boolean validateObject(Customer c) ;
	
	public boolean createAccount(Customer c);

	public boolean isAccountExist(int to_account);

	public boolean login(Customer c);

	public ArrayList<Customer> viewBalance(Customer c);

	public boolean lowBalance(Customer c);

	public boolean deposit(Customer c,int amount);

	public boolean withdrawal(Customer c,int amount);

	public boolean send(Customer c,int account_no_to, int amount);

	public ArrayList<Transaction> printTransaction(Customer c);

}