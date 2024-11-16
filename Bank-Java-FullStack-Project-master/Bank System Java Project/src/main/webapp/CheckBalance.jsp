<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet"href="CheckBalancee.css">
	<link rel="stylesheet"href="css/bootstrap.css">
</head>
<body class="bodyTag">
	<%@ include file="HomeHeader.jsp" %>
	<%@ include file="Nav.jsp" %>
	<main class="form-signin w-100 m-auto">
      <form action="CheckBalance"method="POST">
        <div class="BankName">
          <h1 class="A">A</h1>
          <h1 class="S">S</h1>
          <p class="sub">Axis Secure<br>Bank</p>
        </div>
        <%Double balance=(Double)request.getAttribute("balance");%>
        <%if(balance!=null){ %>
        <p class="psucc">Your Current Balance is <%=balance%></p>
        <%} %>
        <div class="form-floating">
          <input type="password" class="form-control"name="pass" placeholder="Enter your Password">
          <label for="floatingPassword">Enter your PIN</label>
        </div>
        <button class="btn btn-primary Login">CheckBalance</button>
      </form>
    </main>
</body>
</html>