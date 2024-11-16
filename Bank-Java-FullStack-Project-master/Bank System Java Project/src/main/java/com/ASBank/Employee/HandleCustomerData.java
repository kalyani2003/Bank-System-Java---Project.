package com.ASBank.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.ASBank.Customer.Customer;
import com.ASBank.Customer.CustomerDAO;
@WebServlet(urlPatterns = "/HandleCustomerData",loadOnStartup = 2)
public class HandleCustomerData extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Servlet Entered");
		CustomerDAO cdao=new CustomerDAO();
		ArrayList<Customer>customerList=cdao.getCustomer();
		req.setAttribute("cList", customerList);
		RequestDispatcher rd=req.getRequestDispatcher("CustomerDataHandle.jsp");
		rd.forward(req, resp);
		
	}

}
