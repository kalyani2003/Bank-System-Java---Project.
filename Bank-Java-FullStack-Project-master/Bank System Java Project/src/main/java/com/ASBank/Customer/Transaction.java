package com.ASBank.Customer;

public class Transaction {
	int Account_num;
	String ToName;
	String Transfer;
	double Deposite;
	double Balance;
	String Date;
	public int getAccount_num() {
		return Account_num;
	}
	public void setAccount_num(int account_num) {
		Account_num = account_num;
	}
	public String getToName() {
		return ToName;
	}
	public void setToName(String toName) {
		ToName = toName;
	}
	public String getTransfer() {
		return Transfer;
	}
	public void setTransfer(String transfer) {
		Transfer = transfer;
	}
	public double getDeposite() {
		return Deposite;
	}
	public void setDeposite(double deposite) {
		Deposite = deposite;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Transaction(int account_num, String toName, String transfer, double deposite, double balance, String date) {
		super();
		Account_num = account_num;
		ToName = toName;
		Transfer = transfer;
		Deposite = deposite;
		Balance = balance;
		Date = date;
	}
	public Transaction() {
		super();
	}
	
}
