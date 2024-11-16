package com.ASBank.Employee;

public class Employee {
	private int account_number;
	private String Employee_name;
	private long phone;
	private String email;
	private double balance;
	private int pin;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getEmployee_name() {
		return Employee_name;
	}
	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}
	public long getPhone() {
		return phone;
	}
	public Employee(int account_number, String employee_name, long phone, String email, double balance, int pin) {
		super();
		this.account_number = account_number;
		Employee_name = employee_name;
		this.phone = phone;
		this.email = email;
		this.balance = balance;
		this.pin = pin;
	}
	public Employee() {
		super();
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
