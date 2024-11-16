<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"href="Transfer.css">
<link rel="stylesheet"href="css/bootstrap.css">
</head>
<body class="bodyTag">
<%System.out.println("Entered Transfer.jsp"); %>
	<%@ include file="HomeHeader.jsp" %>
	<%@ include file="Nav.jsp" %>
	<main class="form-signin w-100 m-auto">
      <form action="transfer"method="POST">
        <div class="BankName">
          <h1 class="A">A</h1>
          <h1 class="S">S</h1>
          <p class="sub">Axis Secure<br>Bank</p>
        </div>
        <%String Transfered=(String)request.getAttribute("Transfered"); %>
        <%if(Transfered!=null){ %>
        <p class="TSucc"><%=Transfered%></P>
        <%} %>
        <%String error=(String)request.getAttribute("Failed");%>
        <%if(error!=null){ %>
        <p class="TError"><%=error %></p>
        <%} %>
        <div class="form-floating">
          <input type="text" class="form-control" name="reciever"placeholder="Enter the Employee ID">
          <label for="floatingInput">Enter Benificiary Account Number</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control"name="amount" placeholder="Enter your Password">
          <label for="floatingPassword">Enter the Amount</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control"name="pass" placeholder="Enter your Password">
          <label for="floatingPassword">Enter your PIN</label>
        </div>
        <button class="btn btn-primary Login">Pay Now</button>
      </form>
    </main>
</body>
</html>