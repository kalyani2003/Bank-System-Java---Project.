package com.ASBank.Customer;

public class Customer {
	private int account_number;
	private String customer_name;
	private long phone;
	private String email;
	private double balance;
	private int pin;
	public Customer() {
		super();
	}
	public Customer(int account_number, String customer_name, long phone, String email, double balance, int pin) {
		super();
		this.account_number = account_number;
		this.customer_name = customer_name;
		this.phone = phone;
		this.email = email;
		this.balance = balance;
		this.pin = pin;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
