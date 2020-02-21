package com.ibm.bean;

public class Account {

Integer account_no;
int balance;
boolean balance_s;
public Account( int account_no,int balance, String acc_type, boolean balance_s) {
	
	this.balance = balance;
	this.account_no = account_no;
	this.balance_s = balance_s;
}
public Account( Integer balance) {
	
	this.balance = balance;
}

public Account() {
	
}
public Integer getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public Integer getAccount_no() {
	return account_no;
}
public void setAccount_no(int account_no) {
	this.account_no = account_no;
}
public boolean isBalance_s() {
	return balance_s;
}
public void setBalance_s(boolean balance_s) {
	this.balance_s = balance_s;
}
@Override
public String toString() {
	return "Account [balance=" + balance + ", account_no=" + account_no + "]";
	//balance status ? 
}

}