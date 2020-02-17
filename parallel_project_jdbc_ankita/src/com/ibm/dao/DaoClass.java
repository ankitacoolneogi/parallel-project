package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Customer;
import com.ibm.bean.Transaction;

public interface DaoClass {
	
	public boolean createAccount(Customer c);

	public boolean login(Customer c);

	public ArrayList<Customer> viewBalance(Customer c);

	public boolean isLowBalance(Customer c);

	public boolean deposit(Customer c,int amount);

	public boolean withdrawal(Customer c,int amount);

	public boolean send(Customer c,int account_no_to, int amount);

	public ArrayList<Transaction> printTransaction(Customer c);

	public boolean isAccountExist(int to_account);
}