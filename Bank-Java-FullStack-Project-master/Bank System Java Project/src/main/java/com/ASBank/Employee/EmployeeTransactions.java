package com.ASBank.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.ASBank.Customer.CustomerDAO;
import com.ASBank.Customer.Transaction;
@WebServlet(urlPatterns = "/EmployeeTransactions",loadOnStartup = 2)
public class EmployeeTransactions extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet Entered");
		CustomerDAO cdao=new CustomerDAO();
		ArrayList<Transaction>TList=(ArrayList<Transaction>) cdao.EmployeegetTransactions();
		req.setAttribute("TList", TList);
		RequestDispatcher rd=req.getRequestDispatcher("EmployeePassbook.jsp");
		rd.forward(req, resp);
	}

}
