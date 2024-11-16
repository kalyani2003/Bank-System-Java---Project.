package com.ASBank.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/Home",loadOnStartup = 2)
public class Home extends HttpServlet { 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession();
		if(s.getAttribute("account")==null ||s.isNew()) {
			resp.sendRedirect("CustomerLogin.jsp");
			return;
		}
		int Account_num=(int) s.getAttribute("account");
		String Pwd=(String)s.getAttribute("pass");
		String name=(String) s.getAttribute("name");
		s.setAttribute("account",Account_num);
		s.setAttribute("name", name);
		s.setAttribute("password", Pwd);
		resp.sendRedirect("Home.jsp");
//		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
//		rd.forward(req, resp);
	}
}
