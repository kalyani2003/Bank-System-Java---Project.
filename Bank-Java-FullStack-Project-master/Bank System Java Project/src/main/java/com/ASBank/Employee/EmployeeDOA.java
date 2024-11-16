package com.ASBank.Employee;

import java.sql.*;
import java.util.*;

import com.ASBank.Connection.Connector;

public class EmployeeDOA {
	public static Employee getEmployee(int account_number) {
		Employee E=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM EMPLOYEE WHERE ACCNO=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, account_number);
			rs=ps.executeQuery();
			if(rs.next()) {
				E=new Employee();
				E.setAccount_number(rs.getInt(1));
				return E;
			}
		} catch (ClassNotFoundException | SQLException e) {
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
	public static List getEmployee() {
		Employee E=null;
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<Employee>EmployeeList=new ArrayList<Employee>();
		ResultSet rs=null;
		String query="SELECT * FROM EMPLOYEE";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) {
				E=new Employee();
				E.setAccount_number(rs.getInt(1));
				E.setEmployee_name(rs.getString(2));
				E.setPhone(rs.getInt(3));
				E.setEmail(rs.getString(4));
				E.setBalance(rs.getDouble(5));
				E.setPin(rs.getInt(6));
				EmployeeList.add(E);
			}
		} catch (ClassNotFoundException | SQLException e) {
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
		return EmployeeList;
	}
	public static Employee getEmployee(int account_number,int pin) {
		Employee E=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM EMPLOYEE WHERE ACCNO=? AND PIN=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,account_number);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			if(rs.next()) {
				E=new Employee();
				E.setAccount_number(rs.getInt(1));
				E.setEmployee_name(rs.getString(2));
				E.setPhone(rs.getLong(3));
				E.setEmail(rs.getString(4));
				E.setBalance(rs.getDouble(5));
				E.setPin(rs.getInt(6));
				return E;
			}
			else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		catch( NumberFormatException e) {
			System.out.println("Please Enter Integer values only");
		}
		return null;
	}
}
