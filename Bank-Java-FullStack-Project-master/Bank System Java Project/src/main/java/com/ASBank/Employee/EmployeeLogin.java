package com.ASBank.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.ASBank.Connection.Connector;
import com.ASBank.Customer.Customer;
import com.ASBank.Customer.CustomerDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/EmployeeLogin")
public class EmployeeLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		HttpSession s=req.getSession();
		String Account_num=req.getParameter("accno");
		String pass=req.getParameter("pass");
		try {
			EmployeeDOA eoa=new EmployeeDOA();
			int Accno=Integer.parseInt(Account_num);
			int password=Integer.parseInt(pass);
			Employee e=eoa.getEmployee(Accno, password);
			if(e!=null) {
				s.setAttribute("accno",Accno);
				s.setAttribute("name",e.getEmployee_name());
				s.setAttribute("pass", pass);
				resp.sendRedirect("EmployeeHome");
			}
			else {
				req.setAttribute("error","Invalid account num or Pin,Please try again");
				RequestDispatcher rd=req.getRequestDispatcher("EmployeeLogin.jsp");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error","Invalid account num or Pin,Please try again");
			RequestDispatcher rd=req.getRequestDispatcher("EmployeeLogin.jsp");
			rd.forward(req, resp);
		}
	}
}
