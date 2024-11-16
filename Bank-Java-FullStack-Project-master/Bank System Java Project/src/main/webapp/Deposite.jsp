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
    <link rel="stylesheet" href="Deposite.css">
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body class="bodyTag">
    <%@ include file="HomeHeader.jsp" %>
    <%@ include file="Nav.jsp" %>
    <main class="form-signin w-100 m-auto">
      <form action="Deposite"method="POST">
        <div class="BankName">
          <h1 class="A">A</h1>
          <h1 class="S">S</h1>
          <p class="sub">Axis Secure<br>Bank</p>
        </div>
        <%String  namee=(String)request.getAttribute("name");%>
        <%Double balance=(Double)request.getAttribute("balance"); %>
        <%if(namee!=null && balance!=null){ %>
            <p class="balSucc">Hello <%= namee %> you successfully deposited and your balance is <%= balance %></p>
        <%} %>
        <%String  errorr=(String)request.getAttribute("error");%>
        <%if(errorr!=null){ %>
        <p class="balError"><%=errorr %></p>
        <%}%>
        <div class="form-floating">
          <input type="text" class="form-control" name="amount"placeholder="Enter the Employee ID">
          <label for="floatingInput">Enter the Amount</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control"name="password" placeholder="Enter your Password">
          <label for="floatingPassword">Enter your PIN</label>
        </div>
        <button class="btn btn-primary Login">Deposite</button>
      </form>
    </main>
  </body>
</html>