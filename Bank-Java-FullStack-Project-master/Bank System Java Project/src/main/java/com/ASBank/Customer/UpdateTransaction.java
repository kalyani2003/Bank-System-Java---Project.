//Not IN USE Tried Something Went Wrong Now we are not using this


package com.ASBank.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
@WebServlet(urlPatterns = "/UpdateTransaction",loadOnStartup = 2)
public class UpdateTransaction extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
		System.out.println("Entered Servlet");
		HttpSession s=req.getSession();
		if(s.getAttribute("account")==null ||s.isNew()) {
			resp.sendRedirect("CustomerLogin.jsp");
			return;
		}
		String ToAccountName=req.getParameter("ToName");
		System.out.println(ToAccountName);
		String Transfer=req.getParameter("Transfer");
		String Deposite=req.getParameter("deposite");
		String Balance=req.getParameter("balance");
		String Date=req.getParameter("date");
		int AccountNum=(int)s.getAttribute("account");
		try {
			CustomerDAO cdao=new CustomerDAO();
		    double DepositeAmount = 0.0;
		    if (Deposite != null) {
		        Deposite = Deposite.trim();
		        DepositeAmount = Double.parseDouble(Deposite);
		    }

		    double BalanceAmount = 0.0;  // Initialize to default value
		    if (Balance != null) {
		        Balance = Balance.trim();
		        BalanceAmount = Double.parseDouble(Balance);
		    }
			Transaction T=new Transaction();
			T.setAccount_num(AccountNum);
			T.setToName(ToAccountName);
			T.setTransfer(Transfer);
			T.setDeposite(DepositeAmount);
			T.setBalance(BalanceAmount);
			T.setDate(Date);
			System.out.println("Checking");
			boolean Update=cdao.UpdateTransactionData(T);
			System.out.println("DAO Executed");
			System.out.println(Update);
			if(Update) {
	            req.setAttribute("Num", AccountNum);
	            req.setAttribute("Name", ToAccountName);
	            req.setAttribute("transfer", Transfer);
	            req.setAttribute("deposite", DepositeAmount);
	            req.setAttribute("balance", BalanceAmount);
	            req.setAttribute("date", Date);
	            RequestDispatcher rd = req.getRequestDispatcher("TransactionSuccessfull.jsp");
	            System.out.println("Forwarded the setters");
	            rd.forward(req, resp);
			}
			else {
				req.setAttribute("Num", AccountNum);
                req.setAttribute("Name", "Failed");
                req.setAttribute("transfer", "Failed");
                req.setAttribute("deposite", 0.0);
                req.setAttribute("balance", 0.0);
                req.setAttribute("date", "Failed");
                RequestDispatcher rd = req.getRequestDispatcher("TransactionSuccessfull.jsp");
                System.out.println("Forwarded the setters");
                rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}