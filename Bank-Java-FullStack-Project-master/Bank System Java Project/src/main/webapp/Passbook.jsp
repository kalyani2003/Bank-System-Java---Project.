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
    <link rel="stylesheet" href="Passbookk.css">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bodyTag">
    <%@ include file="HomeHeader.jsp" %>
    <%@ include file="Nav.jsp" %>
    <%System.out.println("Entered the Passbook.jsp"); %>
    <h1 class="hTag">Your Transactions</h1> 
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
            ArrayList<Transaction> TransactionData = (ArrayList<Transaction>) request.getAttribute("Transaction");
            if (TransactionData != null && !TransactionData.isEmpty()) {
                for (Transaction T : TransactionData) { 
            %>
                <tr id="row_<%=T.getAccount_num()%>">
                	<td class="Num"><%=T.getAccount_num()%></td>
                	<td><%=T.getToName()%></td>
                	<td><%=T.getTransfer()%></td>
                	<td><%=T.getDeposite()%></td>
                	<td><%=T.getBalance()%></td>
                	<td><%=T.getDate()%></td>
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

