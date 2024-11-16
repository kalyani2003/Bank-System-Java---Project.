<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ASBank.Customer.Customer" %>
<%@ page import="com.ASBank.Customer.Passbook" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PassBook Page</title>
    <link rel="stylesheet" href="Passbookk.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <script>
        function EditItems(Account_num){
        	var row=document.getElementById("row_"+Account_num);
        	var inputs = row.querySelectorAll("input");
            inputs.forEach(function (input) {
            	input.removeAttribute("readonly");
            });
            var numInput = row.querySelector(".Num input");
            if (numInput) {
                numInput.setAttribute("readonly", "true");
            }
        	var editBtn=document.querySelector(".editButton");
        	editBtn.style.display="none";
        	var editHead=document.querySelector(".editHead");
        	editHead.style.display="none";
        	var updateBtn=document.querySelector(".updateButton");
        	updateBtn.style.display="inline-block";
        	updateBtn.style.visibility="visible";
        	var updateHead=document.querySelector(".updateHead");
        	updateHead.style.display="inline-block";
        	updateHead.style.visibility="visible";
        }
    </script>
</head>
<body class="bodyTag">
    <%@ include file="EmployeeHomeHeader.jsp" %>
    <%@ include file="EmployeeNavv.jsp" %>
    <h1 class="hTag">Customer Data</h1> 
    <table>
        <tbody>
            <tr>
                <th>Account Number </th>
                <th>Holder Name</th>
                <th>PhoneNumber</th>
                <th>Email</th>
                <th>Balance</th>
                <th>Delete</th>
                <th class="updateHead">Update</th>
                <th class="editHead">Edit</th>
            </tr>
            <% 
            ArrayList<Customer> CustomerData = (ArrayList<Customer>) request.getAttribute("cList");
            if (CustomerData != null && !CustomerData.isEmpty()) {
                for (Customer c : CustomerData) { 
            %>
                <tr id="row_<%=c.getAccount_number()%>">
                	<form action="ChangeCustomerData"method="POST">
                	<td class="Num"><input type="text"name="acno"value="<%=c.getAccount_number()%>"readonly></td>
                	<td><input type="text"name="Name"value="<%=c.getCustomer_name()%>"readonly></td>
                	<td><input type="text"name="Phone"value="<%=c.getPhone()%>"readonly></td>
                	<td><input type="text"name="Email"value="<%=c.getEmail()%>"readonly></td>
                	<td><input type="text"name="Balance"value="<%=c.getBalance()%>"readonly></td>
                    <td>
                        <button class="btn btn-danger"name="action"value="Delete">Delete</button>
                    </td>
                    <td>
                    	<button class="btn btn-primary updateButton"name="action"value="Update">Update</button>
                    </td>
                    </form>
                    <td>
                        <button class="btn btn-success editButton" onclick="EditItems('<%=c.getAccount_number()%>')">Edit</button>
                    </td>
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

