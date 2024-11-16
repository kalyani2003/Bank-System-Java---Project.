<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ASBank.Customer.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PassBook Page</title>
    <link rel="stylesheet" href="EmployeePassbook.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bodyTag">
    <%@ include file="EmployeeHomeHeader.jsp" %>
    <%@ include file="EmployeeNavv.jsp" %>
    <h1 class="hTag">Customer Transactions</h1> 
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
            <% 
            ArrayList<Transaction> TList = (ArrayList<Transaction>) request.getAttribute("TList");
            if (TList != null && !TList.isEmpty()) {
                for (Transaction T : TList) { 
            %>
                <tr id="row_<%=T.getAccount_num()%>">
                	<form action="EmployeeTransactions" method="POST">
                	<td><%=T.getAccount_num()%></td>
                	<td><%=T.getToName()%></td>
                	<td><%=T.getTransfer()%></td>
                	<td><%=T.getDeposite()%></td>
                	<td><%=T.getBalance()%></td>
                	<td><%=T.getDate()%></td>
                	</form>
                </tr>
            <% } 
            } else { 
            %>
                <tr>
                    <td colspan="8">
                        <div class="NoData">There is No Customer Transactions</div>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>

