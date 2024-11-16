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
    <title>ChangePIN</title>
    <link rel="stylesheet" href="ChangePIN.css">
    <link rel="stylesheet" href="css/bootstrap.css">
  </head>
  <body class="bodyTag">
    <header class="headerTag">
      <div class="containerr">
        <div class="navbar">
          <div class="BankNameH">
            <h1 class="AH">A</h1>
            <h1 class="SH">S</h1>
            <p class="subH">Axis Secure<br>Bank</p>
          </div>
          <ul class="navMain ">
            <li><a href="CustomerLogin.jsp"class="navlinks">CustomerLogin</a></li>
            <li><a href="EmployeeLogin.jsp" class="navlinks">EmployeeLogin</a></li>
            <li><a href="GeneratePIN.jsp" class="navlinks">GeneratePIN</a></li>
            <li><a href="#" class="navlinks">SignUp</a></li>
          </ul>
        </div>
      </div>
    </header>
    <main class="form-signin w-100 m-auto">
      <form action="ChangePIN"method="POST">
        <div class="BankName">
          <h1 class="A">A</h1>
          <h1 class="S">S</h1>
          <p class="sub">Axis Secure<br>Bank</p>
        </div>
        <%String password=(String)request.getAttribute("password"); %>
        <%if(password!=null){ %>
        <p class="tool">
        <%=password%>
        </p>
        <%} %>
        <%String error=(String)request.getAttribute("error"); %>
        <%if(error!=null){ %>
        <p class="tool">
        <%=error %>
        </p>
        <%}%>
        <div class="form-floating">
          <input type="text" class="form-control" name="id"placeholder="Enter the Employee ID">
          <label for="floatingInput">Enter Customer Id</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control"name="phone" placeholder="Enter your Password">
          <label for="floatingPassword">Enter Phoneno</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control"name="pass" placeholder="Enter your Password">
          <label for="floatingPassword">Enter New Password</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control"name="confirm" placeholder="Enter your Password">
          <label for="floatingPassword">Confirm Password</label>
        </div>
        <button class="btn btn-primary Login">ChangePassword</button>
      </form>
    </main>
  </body>
</html>