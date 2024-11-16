package com.ASBank.Customer;

import java.io.IOException;

import com.ASBank.Connection.Connector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/CheckBalance",loadOnStartup = 2)
public class CheckBalance extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession();
		String PIN=req.getParameter("pass");
		try {
			int Account_num=(int) s.getAttribute("account");
			CustomerDAO cdao=new CustomerDAO();
			int Password=Integer.parseInt(PIN);
			Customer c=cdao.getCustomer(Account_num);
			if(c!=null) {
				Double balance=c.getBalance();
				req.setAttribute("balance", balance);
				RequestDispatcher rd=req.getRequestDispatcher("CheckBalance.jsp");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
