package com.ibm.demo;

public class Account {
	String AccountID;
	String Account_Name;
	Double Account_Balance;
	String Pin;
	
	public Account(String accountID, String account_Name, Double account_Balance, String pin) {
		AccountID = accountID;
		Account_Name = account_Name;
		Account_Balance = account_Balance;
		Pin = pin;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	public String getAccount_Name() {
		return Account_Name;
	}

	public void setAccount_Name(String account_Name) {
		Account_Name = account_Name;
	}

	public Double getAccount_Balance() {
		return Account_Balance;
	}

	public void setAccount_Balance(Double account_Balance) {
		Account_Balance = account_Balance;
	}

	public String getPin() {
		return Pin;
	}

	public void setPin(String pin) {
		Pin = pin;
	}
	
}
