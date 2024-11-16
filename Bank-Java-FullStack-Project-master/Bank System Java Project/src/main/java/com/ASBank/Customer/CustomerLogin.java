package com.ASBank.Customer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/CustomerLogin",loadOnStartup = 2)
public class CustomerLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession();
		String Accno=req.getParameter("id");
		String pass=req.getParameter("pass");
		try {
			CustomerDAO cdao=new CustomerDAO();
			int Account_num=Integer.parseInt(Accno);
			int password=Integer.parseInt(pass);
			Customer c=cdao.getCustomer(Account_num, password);
			if(c!=null) {
				s.setAttribute("account",Account_num);
				s.setAttribute("name",c.getCustomer_name());
				s.setAttribute("pass", pass);
				resp.sendRedirect("Home");
			}
			else {
				req.setAttribute("error","Invalid account num or Pin,Please try again");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.jsp");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			req.setAttribute("error","Invalid account num or Pin,Please try again");
			RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.jsp");
			rd.forward(req, resp);
		}
	}
}
