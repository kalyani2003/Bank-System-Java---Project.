<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ASBank.Customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PassBook Page</title>
    <link rel="stylesheet" href="Passbookk.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@ include file="EmployeeHomeHeader.jsp" %>
    <%@ include file="EmployeeNavv.jsp" %>
    <h1 class="hTag">Your Deleted Record</h1> 
    <%	
    	int Account_num=(int)request.getAttribute("Accno");
    	String EName=(String)request.getAttribute("name"); 
    	long Phone=(long)request.getAttribute("phone"); 
    	String Email=(String)request.getAttribute("email"); 
    	double Balance=(double)request.getAttribute("balance"); 
    
    %>
    <table>
        <tbody>
            <tr>
                <th>Account Number </th>
                <th>Holder Name</th>
                <th>PhoneNumber</th>
                <th>Email</th>
                <th>Balance</th>
            </tr>
            <tr>
            	<td><%=Account_num%></td>
            	<td><%=EName%></td>
            	<td><%=Phone%></td>
            	<td><%=Email%></td>
            	<td><%=Balance%></td>
            </tr>
        </tbody>
    </table>
</body>
</html>