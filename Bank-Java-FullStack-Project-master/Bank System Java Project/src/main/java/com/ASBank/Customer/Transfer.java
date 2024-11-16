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
@WebServlet(urlPatterns = "/transfer",loadOnStartup = 2)
public class Transfer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered Transfer.java Servlet");
		HttpSession s=req.getSession();
		String reciever=req.getParameter("reciever");
		String Amount=req.getParameter("amount");
		String password=req.getParameter("pass");
		try {
			int Account_num=(int) s.getAttribute("account");
			int benificiary=Integer.parseInt(reciever);
			double T_Amount=Double.parseDouble(Amount);
			int PIN=Integer.parseInt(password);
			CustomerDAO cdao=new CustomerDAO();
			Customer c1=cdao.getCustomer(Account_num,PIN);
			Customer c2=cdao.getCustomer(benificiary);
			if(c1!=null && c2!=null) {
				double balance=c1.getBalance();
				double benificiary_bal=c2.getBalance();
				if(T_Amount>=0 && T_Amount<=balance && c1.getAccount_number()!=c2.getAccount_number()) {
					balance=balance-T_Amount;
					benificiary_bal=benificiary_bal+T_Amount;
					c1.setBalance(balance);
					c2.setBalance(benificiary_bal);
					Transaction TS=new Transaction();
					TS.setAccount_num(c1.getAccount_number());
					if(Account_num==c1.getAccount_number()) {
						TS.setToName("TO "+c2.getCustomer_name());
					}
					else {
						TS.setToName("FROM "+c2.getCustomer_name());
					}
					TS.setTransfer("- "+T_Amount+" DEBTED");
					TS.setDeposite(0);
					TS.setBalance(c1.getBalance());
					TS.setDate(String.valueOf(new Date()));
					cdao.InsertTransaction(TS);
					Transaction TR=new Transaction();
					TR.setAccount_num(c2.getAccount_number());
					if(Account_num==c2.getAccount_number()) {
						TR.setToName("TO "+c1.getCustomer_name());
					}
					else{
						TR.setToName("FROM "+c1.getCustomer_name());
					}
					TR.setTransfer("+"+T_Amount+" CREDITED");
					TR.setDeposite(0);
					TR.setBalance(c2.getBalance());
					TR.setDate(String.valueOf(new Date()));
					cdao.InsertTransaction(TR);
					boolean Update=cdao.UpdateCustomerData(c1);
					boolean Update_reciever=cdao.UpdateCustomerData(c2);
					System.out.println("Executed two methods");
					req.setAttribute("Transfered","Your Amount "+T_Amount +" "+"Successfully Transfered to "+benificiary+" and your Updated Balance is"+balance);
					RequestDispatcher rd=req.getRequestDispatcher("Transferr.jsp");
//					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp?option=Transfer");
					rd.forward(req, resp);
					
				}
				else {
					req.setAttribute("Failed","Please Enter valid Benificiary Account Number or Amount>0");
					RequestDispatcher rd=req.getRequestDispatcher("Transferr.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("Failed","Incorrect Credentials Please Check with Your accno and PIN");
				RequestDispatcher rd=req.getRequestDispatcher("Transferr.jsp");
				rd.forward(req, resp);
			}
		}catch(NumberFormatException e) {
			req.setAttribute("Failed","Please Enter PIN In Number Format!");
			RequestDispatcher rd=req.getRequestDispatcher("Transferr.jsp");
			rd.forward(req, resp);
		}
		catch(Exception e) {
			req.setAttribute("Failed","Something Went Wrong Please Try Again!");
			RequestDispatcher rd=req.getRequestDispatcher("Transferr.jsp");
			rd.forward(req, resp);
		}
		
	}

}
