package com.ASBank.Customer;

import java.sql.*;
import java.util.*;
import com.ASBank.Connection.Connector;

public class CustomerDAO {
	public static Customer getCustomer(int account_number) {
		Customer c=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM CUSTOMER WHERE ACCNO=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, account_number);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccount_number(rs.getInt(1));
				c.setCustomer_name(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setEmail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				return c;
			}
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList getCustomer() {
		Customer c=null;
		ArrayList<Customer>customerList= new ArrayList<Customer>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM CUSTOMER";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setAccount_number(rs.getInt(1));
				c.setCustomer_name(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setEmail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				customerList.add(c);
			}
		} catch (ClassNotFoundException | SQLException |NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}
	public static Customer getCustomer(int account_number,int pin) {
		Customer c=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,account_number);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccount_number(rs.getInt(1));
				c.setCustomer_name(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setEmail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				return c;
			}
		} catch (ClassNotFoundException | SQLException |NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean UpdateCustomerData(Customer c) {
		System.out.println("called UpdateCustomerData Method");
		Connection con=null;
		PreparedStatement ps=null;
		String query="UPDATE CUSTOMER SET NAME=?,PHONE=?,EMAIL=?,BALANCE=?,PIN=? WHERE ACCNO=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, c.getCustomer_name());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getEmail());
			ps.setDouble(4, c.getBalance());
			ps.setInt(5, c.getPin());
			ps.setInt(6,c.getAccount_number());
			System.out.println("name"+c.getCustomer_name());
			System.out.println("phone"+c.getPhone());
			System.out.println("Email"+c.getEmail());
			System.out.println("balance"+c.getBalance());
			System.out.println("accno"+c.getAccount_number());
			System.out.println("pass"+c.getPin());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException | NumberFormatException |NullPointerException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean DepositeAmount(Customer c,double Amount) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="UPDATE CUSTOMER SET BALANCE=BALANCE+? WHERE ACCNO=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setDouble(1, Amount);
			ps.setInt(2, c.getAccount_number());
			res=ps.executeUpdate();
			return true;
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static Transaction InsertTransaction(Transaction T) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="INSERT INTO TRANSACTIONS(ACCNO,TONAME,TRANSFER,DEPOSITE,BALANCE,DATE)VALUES(?,?,?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,T.getAccount_num());
			ps.setString(2, T.getToName());
			ps.setString(3, T.getTransfer());
			ps.setDouble(4,T.getDeposite());
			ps.setDouble(5,T.getBalance());
			ps.setString(6, T.getDate());
			res=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException |NumberFormatException e) {
			e.printStackTrace();
		}
		return T;
	}
	public static List EmployeegetTransactions() {
		Transaction T=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Transaction>TransactionList=new ArrayList<Transaction>();
		String query="SELECT * FROM TRANSACTIONS";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				T=new Transaction();
				T.setAccount_num(rs.getInt(2));
				T.setToName(rs.getString(3));
				T.setTransfer(rs.getString(4));
				T.setDeposite(rs.getDouble(5));
				T.setBalance(rs.getDouble(6));
				T.setDate(rs.getString(7));
				TransactionList.add(T);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return TransactionList;
	}
	public static List CustomergetTransactions(int Account_num) {
		Transaction T=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Transaction>TransactionList=new ArrayList<Transaction>();
		String query="SELECT * FROM TRANSACTIONS WHERE ACCNO=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, Account_num);
			rs=ps.executeQuery();
			while(rs.next()) {
				T=new Transaction();
				T.setAccount_num(rs.getInt(2));
				T.setToName(rs.getString(3));
				T.setTransfer(rs.getString(4));
				T.setDeposite(rs.getDouble(5));
				T.setBalance(rs.getDouble(6));
				T.setDate(rs.getString(7));
				TransactionList.add(T);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return TransactionList;
	}
	public static boolean UpdateTransactionData(Transaction T) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="UPDATE TRANSACTIONS SET TONAME=?,TRANSFER=?,DEPOSITE=?,BALANCE=?,DATE=? WHERE ACCNO=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, T.getToName());
			ps.setString(2, T.getTransfer());
			ps.setDouble(3, T.getDeposite());
			ps.setDouble(4, T.getBalance());
			ps.setString(5,T.getDate());
			ps.setInt(6, T.getAccount_num());
			res=ps.executeUpdate();
			System.out.println("UpdateTransactionData method executed!");
			return true;
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean DeleteCustomerRecord(Customer c) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="DELETE FROM CUSTOMER WHERE ACCNO=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,c.getAccount_number());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}





























