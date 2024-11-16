package com.ASBank.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.util.*;
@WebServlet(urlPatterns = "/Passbook",loadOnStartup = 2)
public class Passbook extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//Here we are using doGet method because we are trying to access this List elements in Passbook.jsp so there we have to Display the items not to Post
		//The Items so thats why we have to use the doGet Method here.
		HttpSession s=req.getSession();
		if(s.getAttribute("account")==null ||s.isNew()) {
			resp.sendRedirect("CustomerLogin.jsp");
			return;
		}
		int Account_num=(int) s.getAttribute("account");
		CustomerDAO cdao=new CustomerDAO();
//		System.out.println("Instantiated");
//		ArrayList<Customer> CustomerList=cdao.getCustomer();
		ArrayList<Transaction>TransactionList=(ArrayList<Transaction>) cdao.CustomergetTransactions(Account_num);
//		System.out.println("Number of records retrieved from the database: " + CustomerList.size());
		req.setAttribute("Transaction",TransactionList);
		RequestDispatcher rd=req.getRequestDispatcher("Passbook.jsp");
		rd.forward(req, resp);
	}
}
