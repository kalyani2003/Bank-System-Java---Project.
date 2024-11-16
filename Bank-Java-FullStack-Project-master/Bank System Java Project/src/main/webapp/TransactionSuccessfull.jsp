<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ASBank.Customer.Transaction" %>
<%@ page import="com.ASBank.Customer.Passbook" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PassBook Page</title>
    <link rel="stylesheet" href="Passbook.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bodyTag">
	<%@ include file="HomeHeader.jsp" %>
    <%@ include file="Nav.jsp" %>
    <h1 class="hTag">You Updated This Record</h1> 
    <%int accountNum=(int)request.getAttribute("Num");
    String Toname=(String)request.getAttribute("Name");
    String Transfer=(String)request.getAttribute("transfer");
    double DepositeAmount=(double)request.getAttribute("deposite");
    double Balance=(double)request.getAttribute("balance");
    String Date=(String)request.getAttribute("date");
    System.out.println(accountNum);
    %>
    <table>
        <tbody>
            <tr>
                <th>Account Number </th>
                <th>To/From</th>
                <th>Debit/Credit</th>
                <th>Deposite</th>
                <th>Balance</th>
                <th>Date</th>
            </tr>
            <tr>
               	<td><%=accountNum%></td>
               	<td><%=Toname%></td>
               	<td><%=Transfer%></td>
               	<td><%=DepositeAmount%></td>
               	<td><%=Balance%></td>
               	<td><%=Date%></td>
            </tr>
        </tbody>
    </table>
</body>
</html>