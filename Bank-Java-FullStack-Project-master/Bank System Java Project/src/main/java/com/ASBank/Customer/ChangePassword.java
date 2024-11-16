package com.ASBank.Customer;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/ChangePIN",loadOnStartup = 2)
public class ChangePassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Account=req.getParameter("id");
		String phone=req.getParameter("phone");
		String pass=req.getParameter("pass");
		String conf=req.getParameter("confirm");
		try {
			int Account_number=Integer.parseInt(Account);
			int password=Integer.parseInt(pass);
			int confirm=Integer.parseInt(conf);
			CustomerDAO cdao=new CustomerDAO();
			Customer c=cdao.getCustomer(Account_number);
			if(password==confirm) {
				c.setPin(password);
				System.out.println("Set the password"+c.getPin());
				boolean res=cdao.UpdateCustomerData(c);
				req.setAttribute("password", "Password Successfully updated");
				RequestDispatcher rd=req.getRequestDispatcher("ChangePIN.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("error", "Password Failed to update");
				RequestDispatcher rd=req.getRequestDispatcher("ChangePIN.jsp");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			req.setAttribute("error", "Something Went Wrong Please Try again Later!");
			RequestDispatcher rd=req.getRequestDispatcher("ChangePIN.jsp");
			rd.forward(req, resp);
		}
	}
}
