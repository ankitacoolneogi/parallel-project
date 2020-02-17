package com.ibm.bean;

import java.util.Date;

public class Customer {
int id;
int account_no;
String account_type;
String name;
Date dob;
String password;
String phone;
String address;
String email;
public Account a;
public Customer(int id, int account_no,String account_type, String name, Date dob, String password, String phone,String email) {
	
	this.id = id;
	this.account_no = account_no;
	this.name = name;
	this.dob = dob;
	this.password = password;
	this.phone = phone;
	this.address = address;
	this.email=email;
	 a=new Account();
}

public Customer() {
	a=new Account();
	
}
 public void setA(Account acc) {
	 a=acc;
 }




public Integer getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Integer getAccount_no() {
	return account_no;
}

public void setAccount_no(int account_no) {
	this.account_no = account_no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", " + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", "+ "email=" + email +" \n" + a +"]";
}





}