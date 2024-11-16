package com.ASBank.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ASBank.Customer.Customer;
import com.ASBank.Customer.CustomerDAO;
@WebServlet(urlPatterns = "/ChangeCustomerData",loadOnStartup = 2)
public class ChangeCustomerData extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Entered Servlet");
		HttpSession s=req.getSession();
		Customer c1=new Customer();
		if(s.getAttribute("account")==null ||s.getAttribute("pass")==null||s.isNew()) {
			resp.sendRedirect("CustomerLogin.jsp");
			return;
		}
		String AccountNum=req.getParameter("acno");
		String HolderName=req.getParameter("Name");
		String Phone=req.getParameter("Phone");
		String Email=req.getParameter("Email");
		String Balance=req.getParameter("Balance");
		int Accno=Integer.parseInt(AccountNum);
		String action=req.getParameter("action");
		if(action.equals("Update")) {
			try {
				long Phone_num=Long.parseLong(Phone);
				double Balance_Amount=Double.parseDouble(Balance);
				CustomerDAO cdao=new CustomerDAO();
				c1.setAccount_number(Accno);
				c1.setCustomer_name(HolderName);
				c1.setPhone(Phone_num);
				c1.setEmail(Email);
				c1.setBalance(Balance_Amount);
//				c1.setPin(c1.getPin());
				System.out.println("num "+AccountNum+" Name "+HolderName+" PhoneNumber "+Phone_num+" Email "+Email+" Balance "+Balance_Amount+" Password "+c1.getPin());
				boolean res=cdao.UpdateCustomerData(c1);
				System.out.println(res);
				if(res) {
					req.setAttribute("Accno", AccountNum);
					req.setAttribute("name",HolderName);
					req.setAttribute("phone",Phone_num);
					req.setAttribute("email",Email);
					req.setAttribute("balance",Balance_Amount);
					RequestDispatcher rd=req.getRequestDispatcher("UpdatedRecords.jsp");
					rd.forward(req, resp);
				}
				else {
					req.setAttribute("Accno",0);
					req.setAttribute("name","Failed");
					req.setAttribute("phone",0);
					req.setAttribute("email","Failed");
					req.setAttribute("balance",0.0);
					RequestDispatcher rd=req.getRequestDispatcher("UpdatedRecords.jsp");
					rd.forward(req, resp);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("Delete")) {
			try {
				long Phone_num=Long.parseLong(Phone);
				double Balance_Amount=Double.parseDouble(Balance);
				CustomerDAO cdao=new CustomerDAO();
				c1.setAccount_number(Accno);
				c1.setCustomer_name(HolderName);
				c1.setPhone(Phone_num);
				c1.setEmail(Email);
				c1.setBalance(Balance_Amount);
//				c1.setPin(c1.getPin());
				boolean res=cdao.DeleteCustomerRecord(c1);
				if(res) {
					req.setAttribute("Accno", Accno);
					req.setAttribute("name",HolderName);
					req.setAttribute("phone",Phone_num);
					req.setAttribute("email",Email);
					req.setAttribute("balance",Balance_Amount);
					RequestDispatcher rd=req.getRequestDispatcher("DeletedRecords.jsp");
					rd.forward(req, resp);
				}
				else {
					req.setAttribute("Accno",0);
					req.setAttribute("name","Failed");
					req.setAttribute("phone",0);
					req.setAttribute("email","Failed");
					req.setAttribute("balance",0.0);
					RequestDispatcher rd=req.getRequestDispatcher("DeletedRecords.jsp");
					rd.forward(req, resp);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
