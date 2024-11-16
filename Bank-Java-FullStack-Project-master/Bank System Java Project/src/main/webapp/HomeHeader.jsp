<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
  margin: 0;
  padding: 0;
  font-family: "poppins",sans-serif;
}
.Welcome{
  font-size: 30px;
  margin-left: -75px;
}
.AH{
  color: purple;
  font-family: cursive;
  transform: rotate(-12deg);
  font-size: 40px;
}
.SH{
  color: rgb(216, 84, 84);
  font-family: cursive;
  font-size: 40px;
  margin-left: -15px;
  transform: rotate(-10deg);
}
.BankNameH{
  display: flex;
  margin-left: 30px;
}
.subH{
  margin-left: 20px;
  margin-top: 6px;
  font-size: 15px;
  color: blueviolet;
  font-weight: 700;
}
.headerTag{
  background-image:linear-gradient(rgba(255,255,255,0.7),rgba(255,255,255,0.7));
  height: 70px;
  position: relative;
  width: 100%;
}
.Logout{
  margin-right: 30px;
  margin-bottom: 10px;
  width: 100px;
}
.Logout a{
  color: white;
  text-decoration: none;
}
</style>
</head>
<body>
	<header class="headerTag">
      <div class="containerr">
        <div class="navbar">
          <div class="BankNameH">
            <h1 class="AH">A</h1>
            <h1 class="SH">S</h1>
            <p class="subH">Axis Secure<br>Bank</p>
          </div>
          <%String name=(String)session.getAttribute("name"); %>
          <p class="Welcome">Welcome <%=name %></p>
          <div class="Buttons">
            <button class="btn btn-primary Logout"><a href="CustomerLogin.jsp">LogOut</a></button>
          </div>
        </div>
      </div>
    </header>
</body>
</html>