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
  	<%@ include file="EmployeeHomeHeader.jsp"%>
  	<%@include file="EmployeeNavv.jsp"%>
  	<%
  	String option=(String)request.getParameter("option");
  	if(option==null||option.isEmpty()){
  		option="EmployeeHome.jsp";
  	}
  	else{
  		switch(option){
  			case "ETransactions":
  				request.getRequestDispatcher("EmployeeTransactions").include(request,response);
  				break;
  			case "EChangeData":
  				request.getRequestDispatcher("HandleCustomerData").include(request,response);
  				break;
  		}
  	}
  	%>
</head>
<body>

</body>
</html>