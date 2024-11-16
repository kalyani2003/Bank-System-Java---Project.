package com.ASBank.Customer;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/PINGenerate",loadOnStartup = 2)
public class GeneratePIN extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accno=req.getParameter("id");
		String phone=req.getParameter("phone");
		String pass=req.getParameter("pass");
		String cnf=req.getParameter("confirm");
		try {
			int account_number=Integer.parseInt(accno);
			int passWord=Integer.parseInt(pass);
			CustomerDAO cdao=new CustomerDAO();
			Customer c=cdao.getCustomer(account_number);
			int pwd=c.getPin();
			String password=String.valueOf(pwd);
			if (password.equals("0")&& pass.equals(cnf)) {
				c.setPin(passWord);
				System.out.println(c.getPin());
				boolean res=cdao.UpdateCustomerData(c);
				System.out.println(res);
				req.setAttribute("password","PIN generated Successfully");
				RequestDispatcher rd=req.getRequestDispatcher("GeneratePIN.jsp");
				rd.forward(req,resp);
			}
			else {
				req.setAttribute("error","You already have a Password");
				RequestDispatcher rd=req.getRequestDispatcher("GeneratePIN.jsp");
				rd.forward(req,resp);
			}
		}
		catch(Exception e) {
			req.setAttribute("error","Please Enter Valid Account Number");
			RequestDispatcher rd=req.getRequestDispatcher("GeneratePIN.jsp");
			rd.forward(req,resp);
		}
	}
}
