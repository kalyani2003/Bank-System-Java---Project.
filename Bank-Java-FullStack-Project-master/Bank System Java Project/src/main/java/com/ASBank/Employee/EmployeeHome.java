package com.ASBank.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/EmployeeHome",loadOnStartup = 2)
public class EmployeeHome extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession();
		if(s.isNew()||s.getAttribute("accno")==null) {
			resp.sendRedirect("EmployeeLogin.jsp");
			return;
		}
		int Account=(int)s.getAttribute("accno");
		String EmployeeName=(String)s.getAttribute("name");
		String password=(String)s.getAttribute("pass");
		s.setAttribute("account", Account);
		s.setAttribute("password", password);
		s.setAttribute("name", EmployeeName);
		RequestDispatcher rd=req.getRequestDispatcher("EmployeeHome.jsp");
		rd.forward(req, resp);
	}
}
