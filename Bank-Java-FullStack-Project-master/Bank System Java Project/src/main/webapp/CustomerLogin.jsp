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
    <title>CustomerLogin</title>
    <link rel="stylesheet" href="CustomerLogin.css">
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body class="bodyTag">
  <%@ include file="LoginHeader.jsp" %>
    <main class="form-signin w-100 m-auto">
      <form action="CustomerLogin"method="POST">
        <div class="BankName">
          <h1 class="A">A</h1>
          <h1 class="S">S</h1>
          <p class="sub">Axis Secure<br>Bank</p>
        </div>
        <% String accno=(String)request.getAttribute("account");%>
       	<%if(accno!=null){%>
	       	<p class="tool"style="color:red">
	       		<%=accno %>
	       	</p>
       	<%}%>
       	<% String error=(String)request.getAttribute("error");%>
       	<%if(error!=null){ %>
	       	<p class="tool"style="color:red">
	       	<%=error %>
	       	</p>
       	<%} %>
        <div class="form-floating">
          <input type="text" class="form-control" name="id"placeholder="Enter Customer AccountNumber">
          <label for="floatingInput">Enter Customer Id</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control"name="pass" placeholder="Enter your Password">
          <label for="floatingPassword">Enter your Password</label>
        </div>
        <button class="btn btn-primary Login">Login</button>
        <a class="forgot"href="ChangePIN.jsp">Forgot Password?</a>
      </form>
    </main>
  </body>
</html>/html>