package com.ASBank.Customer;

import java.io.IOException;
import java.util.Date;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/Deposite",loadOnStartup = 2)
//Because of Single page it is updating for every refresh it is depositing the amount of previous amount again and again.
public class Deposite extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String accno=req.getParameter("accno");
//		String password=req.getParameter("password");
		HttpSession s=req.getSession();
		int Account_num=(int) s.getAttribute("account");
		String amount=req.getParameter("amount");
		String password=req.getParameter("password");
		try {
			CustomerDAO cdao=new CustomerDAO();
			int pass=Integer.parseInt(password);
			Customer c=cdao.getCustomer(Account_num, pass);
			double Amount=Double.parseDouble(amount);
			String name=c.getCustomer_name();
			if (c != null) {
				if(Amount>0 && amount!=null) {
					boolean res=cdao.DepositeAmount(c,Amount);
					if(res) {
						Transaction T=new Transaction();
						T.setAccount_num(c.getAccount_number());
						T.setToName("TO "+c.getCustomer_name());
						T.setTransfer("SELF");
						T.setDeposite(Amount);
						T.setDate(String.valueOf(new Date()));
						T.setBalance(Amount+c.getBalance());
						cdao.InsertTransaction(T);
						Double balance=c.getBalance()+Amount;
						c.setBalance(balance);
						req.setAttribute("name", name);
						req.setAttribute("balance",balance);
						RequestDispatcher rd=req.getRequestDispatcher("Deposite.jsp");
						rd.forward(req, resp);
					}
					else {
						req.setAttribute("name", name);
						req.setAttribute("error","Please Check with Your Account number or PIN");
						RequestDispatcher rd=req.getRequestDispatcher("Deposite.jsp");
						rd.forward(req, resp);
					}
				}
				else {
					req.setAttribute("error", "Please Enter Valid Amount");
					RequestDispatcher rd=req.getRequestDispatcher("Deposite.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error", "Incorrect Account num or Password");
				RequestDispatcher rd=req.getRequestDispatcher("Deposite.jsp");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			req.setAttribute("error", "Failed to Deposite the amount");
			RequestDispatcher rd=req.getRequestDispatcher("Deposite.jsp");
			rd.forward(req, resp);
		}
	}
}
