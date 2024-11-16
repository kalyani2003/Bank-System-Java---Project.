<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.118.2">
    <title>HomePage</title>
    <link rel="stylesheet" href="Home.css">
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body class="bodyTag">
  <main>
	  <%@ include file="HomeHeader.jsp" %>
	  <%@ include file="Nav.jsp"%>
	  <%
	  String option=request.getParameter("option");
	  if(option==null||option.isEmpty()){
		  option="Home.jsp";
	  }
	  else{
		  switch(option){
		  case "Transfer":
			  request.getRequestDispatcher("Transferr.jsp").forward(request,response);
			  break;
		  case "CheckBalance":
			  request.getRequestDispatcher("CheckBalance.jsp").include(request,response);
			  break;
		  case "Deposit":
			  request.getRequestDispatcher("Deposite.jsp").include(request,response);
			  break;
		  case "Passbook":
			  request.getRequestDispatcher("Passbook").include(request,response);
			  //Here lets understand why used directly Passbook servlet here when i click on Passbook link in my Nav.jsp there it will navigate to Home.jsp
			  //with Passbook option so if i provide here directly Passbook.jsp it again directly goes to Passbook.jsp without entering into the Passbook.jsp
			  //Servlet so that why i used this Servlet directly here if i use Passbook servlet here it goes to Passbook.java Servlet there it get the Transaction
			  //List using DAO.CustomergetTransactions(); after getting that the Transaction List according to account number and then after give forward that 
			  //Data into Passbook.jsp in Passbook.jsp it will access the data and it will print the data in td column by using loop.
			  break;
		  /* case "Transactions":
			  request.getRequestDispatcher("EmployeeTransactions").forward(request,response);
			  break;
		  case "ChangeData":
			  request.getRequestDispatcher("HandleCustomerData").forward(request,response);
			  break; */
		  }
	  }
	  %>
  </main>
  </body>
</html>